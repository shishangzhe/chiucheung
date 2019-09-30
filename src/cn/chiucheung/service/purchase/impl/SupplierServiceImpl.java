package cn.chiucheung.service.purchase.impl;

import cn.chiucheung.dao.mapper.purchase.material.WarMaterialPriceMapper;
import cn.chiucheung.dao.mapper.purchase.supplier.PurSupplierFileMapper;
import cn.chiucheung.dao.mapper.purchase.supplier.PurSupplierMapper;
import cn.chiucheung.dao.mapper.purchase.supplier.SupplierMaterialRelationMapper;
import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.purchase.material.WarMaterialPriceExample;
import cn.chiucheung.po.purchase.supplier.*;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierCustomer;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierQueryVo;
import cn.chiucheung.pojo.purchase.supplier.SupplierMaterialCustomer;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.purchase.SupplierService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    PurSupplierMapper purSupplierMapper;
    @Autowired
    PurSupplierFileMapper purSupplierFileMapper;
    @Autowired
    SupplierMaterialRelationMapper supplierMaterialRelationMapper;

    @Override
    public Map<String, Object> selectSupplierById(String supplierId) {
        HashMap<String, Object> map = new HashMap<>();
        //查询供应商信息
        try {
            PurSupplier purSupplier = purSupplierMapper.selectByPrimaryKey(supplierId);
            map.put("success",true);
            map.put("purSupplier",purSupplier);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public List<PurSupplierCustomer> selectSupplierList(PurSupplierQueryVo purSupplierQueryVo) {
        return purSupplierMapper.selectSupplierList(purSupplierQueryVo);
    }

    @Override
    public String selectSupplierCount(PurSupplierQueryVo purSupplierQueryVo) {
        return purSupplierMapper.selectSupplierCount(purSupplierQueryVo);
    }

    @Override
    public Map<String, Object> insertSupplier(PurSupplier purSupplier, MultipartFile[] businessLicenseFile, MultipartFile[] registeredTrademarkFile) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        //新增时自动填入uuid
        String purSupplierId = UUIDBuild.getUUID();
        purSupplier.setId(purSupplierId);
        //新增供应商信息
        int i = purSupplierMapper.insertSelective(purSupplier);

        insertFile(businessLicenseFile,"business ", purSupplierId);

        insertFile(registeredTrademarkFile,"registered", purSupplierId);

        if (i > 0) {
            map.put("success", true);
            map.put("message", "操作成功");
        } else {
            map.put("success", false);
            map.put("message", "操作失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateSupplier(PurSupplier purSupplier, MultipartFile[] businessLicenseFile, MultipartFile[] registeredTrademarkFile) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path"), "purchase/PurSupplier");
        int i = purSupplierMapper.updateByPrimaryKeySelective(purSupplier);
        insertFile(businessLicenseFile,"business ", purSupplier.getId());

        insertFile(registeredTrademarkFile,"registered", purSupplier.getId());

        if (i > 0) {
            map.put("success", true);
            map.put("message", "操作成功");
        } else {
            map.put("success", false);
            map.put("message", "操作失败");
        }

        return map;
    }

    @Override
    public Map<String, Object> deleteSupplier(String supplierId) throws Exception{
        int i = 0;
        Map<String, Object> map = new HashMap<>();

        //创建关联物料对象的example
        SupplierMaterialRelationExample materialRelationExample = new SupplierMaterialRelationExample();
        materialRelationExample.createCriteria().andSupplierIdEqualTo(supplierId);
        //删除关联的物料信息
        try {
            i = supplierMaterialRelationMapper.deleteByExample(materialRelationExample);
        }catch (Exception e){
            throw new Exception("关联物料删除失败");
        }

        //创建附属文件对象的example
        PurSupplierFileExample supplierFileExample = new PurSupplierFileExample();
        supplierFileExample.createCriteria().andPurSupplierIdEqualTo(supplierId);
        //获取供应商附属文件对象
        List<PurSupplierFile> supplierFiles = purSupplierFileMapper.selectByExample(supplierFileExample);
        if (supplierFiles.size()>0){
            //获取存储图片的路径
            String localPath = ResourcesUtil.getValue("fileRootPath", "path") + "/purchase/PurSupplier";
            //获取属于该供应商的全部文件信息
            for (PurSupplierFile supplierFile:supplierFiles){
                String filePath = supplierFile.getFilePath();
                //判断是否存在图片且图片是文件的形式,若存在且是文件形式则对图片进行删除操作
                File fileDir = new File(localPath,filePath);
                if (fileDir.exists() && fileDir.isFile()) {
                    boolean b = fileDir.delete();
                    if (!b){
                        throw new IOException("文件删除失败");
                    }
                }
            }
            //删除附属文件对象
            try {
                i = i + purSupplierFileMapper.deleteByExample(supplierFileExample);
            }catch (Exception e){
                throw new Exception("附属文件删除失败");
            }

        }
        //删除供应商对象
        try {
            i = i + purSupplierMapper.deleteByPrimaryKey(supplierId);
        }catch (Exception e){
            throw new Exception("供应商删除失败");
        }

        if (i > 0) {
            map.put("success", true);
            map.put("message", "操作成功");
        } else {
            map.put("success", false);
            map.put("message", "操作失败");
        }
        return map;
    }

    @Override
    public int deleteFileById(String id) {
        PurSupplierFile supplierFile = purSupplierFileMapper.selectByPrimaryKey(id);
        File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/purchase/PurSupplier", supplierFile.getFilePath());
        if (file.exists()){
            if(!file.delete()){
                throw new RuntimeException("文件删除失败");
            }
        }
        return purSupplierFileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectFileBySupplierId(String supplierId){
        HashMap<String, Object> map = new HashMap<>();
        PurSupplierFileExample supplierFileExample = new PurSupplierFileExample();
        supplierFileExample.createCriteria().andPurSupplierIdEqualTo(supplierId);
        //查询文件信息
        try {
            List<PurSupplierFile> supplierFiles = purSupplierFileMapper.selectByExample(supplierFileExample);
            map.put("success",true);
            if (supplierFiles.size()>0){
                map.put("supplierFiles",supplierFiles);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return map;

    }

    @Override
    public Map<String, Object> insertSupplierAndMaterial(String supplierId, String material) {
        HashMap<String, Object> map = new HashMap<>();
        //创建一个集合装多循环插入的对象
        List<SupplierMaterialRelation> supplierMaterialRelationList = new ArrayList<>();

        String[] materials = material.split(",");
        int i = 0;
        //将需要插入的对象循环放入集合中
        for (String materialString : materials) {
            SupplierMaterialRelation supplierMaterialRelation = new SupplierMaterialRelation();
            supplierMaterialRelation.setSupplierId(supplierId);
            supplierMaterialRelation.setCreateTime(new Date());
            supplierMaterialRelation.setMaterialId(materialString);

            supplierMaterialRelationList.add(supplierMaterialRelation);
        }
        i = supplierMaterialRelationMapper.insertListInfo(supplierMaterialRelationList);

        if (i > 0) {
            map.put("success", true);
            map.put("message", "操作成功");
        } else {
            map.put("success", false);
            map.put("message", "操作失败");
        }

        return map;
    }

    @Override
    public Map<String, Object> selectInfoBySupplierId(WarMaterialQueryVo materialQueryVo) {
        HashMap<String, Object> map = new HashMap<>();
        List<SupplierMaterialCustomer> supplierMaterialCustomers = supplierMaterialRelationMapper.selectInfoBySupplierId(materialQueryVo);
        String count = supplierMaterialRelationMapper.selectCountBySupplierId(materialQueryVo);
        map.put("rows",supplierMaterialCustomers);
        map.put("total",count);

        return map;
    }

    @Override
    public Map<String, Object> deleteByMaterialId(String materials){
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<String>();
        String[] materialIds = materials.split(",");
        if (materialIds.length > 0) {
            for (int j = 0; j <materialIds.length; j++) {
                list.add(materialIds[j]);
            }
        }

        SupplierMaterialRelationExample materialRelationExample = new SupplierMaterialRelationExample();
        materialRelationExample.createCriteria().andMaterialIdIn(list);
        int i = supplierMaterialRelationMapper.deleteByExample(materialRelationExample);
        if (i > 0){
            map.put("success",true);
            map.put("message","操作成功");
        }else {
            map.put("success",false);
            map.put("message","操作失败");
        }
        return map;
    }


    //循环插入图片信息,如果成功则返回图片路径,失败则返回空字符串
    private void insertFile(MultipartFile[] multipartFiles,String type, String purSupplierId) throws IOException {
        List<PurSupplierFile> purSupplierFiles = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            //创建供应商附属文件对象
            PurSupplierFile supplierFile = new PurSupplierFile();
            //多个文件创建多个uuid
            String uuid = UUIDBuild.getUUID();

            if (!multipartFile.isEmpty()) {

                //获取需要创建的文件夹路径
                File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path"), "purchase/PurSupplier/");
                //判断文件是否存在,不存在则自动创建
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                //获取当前文件的文件名称
                String multipartFileName = multipartFile.getOriginalFilename();
                //File()中,前面的必须是完整的文件夹路径名称,后面的是需要存入的文件的名称
                File file = new File(fileDir, uuid + multipartFileName);
                try {
                    multipartFile.transferTo(file);
                }catch (FileNotFoundException e){
                    throw new RuntimeException(e);
                }
                //对相对应的文件进行赋值
                supplierFile.setId(UUIDBuild.getUUID());
                supplierFile.setFileName(multipartFileName);
                supplierFile.setFilePath(uuid + multipartFileName);
                supplierFile.setFileType(type);
                supplierFile.setPurSupplierId(purSupplierId);

                purSupplierFiles.add(supplierFile);

                //单条插入数据
                /*int i = purSupplierFileMapper.insertSelective(supplierFile);
                if (i<=0){
                    //如果新增失败则删除新增的图片
                    String localPath = ResourcesUtil.getValue("fileRootPath", "path") + "/purchase/PurSupplier/" + uuid + multipartFileName;
                    File files = new File(localPath);
                    if (files.isFile() && files.exists()) {
                        files.delete();
                    }
                }*/
            }
        }

        try {
            //多条插入数据
            purSupplierFileMapper.insertSupplierFileList(purSupplierFiles);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


}
