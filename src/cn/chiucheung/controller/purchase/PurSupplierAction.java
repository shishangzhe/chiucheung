package cn.chiucheung.controller.purchase;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.purchase.supplier.PurSupplier;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierQueryVo;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.purchase.SupplierService;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.FileUtils;
import cn.chiucheung.utils.ResourcesUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchase/warehousing")
public class PurSupplierAction {

    @Autowired
    SupplierService supplierService;
    @Autowired
    private MaterialService materialService;


    @RequestMapping("index")
    @AnnotationLimit(pid="ee",mid="ea")
    public String index(){
        return "purchase/supplierAction";
    }

    /**
     * 根据id查询供应商信息
     * @param supplierId id
     */
    @RequestMapping("selectSupplierById")
    @ResponseBody
    @AnnotationLimit(pid="ee",mid="ea")
    public Map<String, Object> selectSupplierById(String supplierId){
        return supplierService.selectSupplierById(supplierId);
    }

    /**
     * 查询所有供应商信息
     * @param purSupplierQueryVo 根据的条件
     * @return 供应商信息
     */
    @RequestMapping("selectSupplierList")
    @ResponseBody
    @AnnotationLimit(pid="ee",mid="ea")
    public Map<String, Object> selectSupplierList(PurSupplierQueryVo purSupplierQueryVo){
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",supplierService.selectSupplierCount(purSupplierQueryVo));
        map.put("rows",supplierService.selectSupplierList(purSupplierQueryVo));
        return map;
    }

    /**
     * 新增供应商信息
     * @param purSupplier 基本信息
     * @param businessLicenseFile 营业执照图片
     * @param registeredTrademarkFile 注册商标图片
     */
    @RequestMapping("insertSupplier")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eaa")
    public Map<String, Object> insertSupplier(PurSupplier purSupplier,
                                                   @RequestParam(value = "businessLicenseFile") MultipartFile[] businessLicenseFile,
                                                   @RequestParam(value = "registeredTrademarkFile") MultipartFile[] registeredTrademarkFile){
        Map<String, Object> map = new HashMap<>();
        try {
            map = supplierService.insertSupplier(purSupplier, businessLicenseFile, registeredTrademarkFile);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","图片插入失败");
        }
        return map;
    }

    /**
     * 修改供应商信息
     * @param purSupplier 基本信息
     * @param businessLicenseFile 营业执照图片
     * @param registeredTrademarkFile 注册商标图片
     */
    @RequestMapping("updateSupplier")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eab")
    public Map<String, Object> updateSupplier(PurSupplier purSupplier,
                                              @RequestParam(value = "businessLicenseFile") MultipartFile[] businessLicenseFile,
                                              @RequestParam(value = "registeredTrademarkFile") MultipartFile[] registeredTrademarkFile){
        Map<String, Object> map = new HashMap<>();
        try {
        map = supplierService.updateSupplier(purSupplier,businessLicenseFile,registeredTrademarkFile);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","图片插入失败");
        }

        return map;
    }

    /**
     * 根据供应商id删除相对应的供应商信息
     * @param supplierId 供应商id
     */
    @RequestMapping("deleteSupplier")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eac")
    public Map<String, Object> deleteSupplier(String supplierId){
        Map<String, Object> map = new HashMap<>();
        try {
            map = supplierService.deleteSupplier(supplierId);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    /**
     * 根据图片路径获取图片
     * @param path 图片路径
     * @param response 响应
     */
    @RequestMapping("getFileInfo")
    @ResponseBody
    @AnnotationLimit(pid="ee",mid="ea")
    public void getFileInfo(String path, HttpServletResponse response){
        File file = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/purchase/PurSupplier/"+path);
        FileUtils.downloadFile(response, file);
    }

    /**
     * 根据物料文件id查询物料附属文件
     * @param id 物料文件Id
     */
    @RequestMapping("readFileById")
    @ResponseBody
    @AnnotationLimit(pid="ee",mid="ea")
    public void readFileById(String id, HttpServletResponse response){
        WarMaterialFile materialFile = materialService.findMaterialFileById(id);
        File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material",materialFile.getFilePath());
        FileUtils.downloadFile(response, file);
    }

    /**
     * 根据文件id删除文件
     * @param id 文件id
     */
    @RequestMapping("deleteFileById")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eac")
    public JSONObject deleteFileById(String id){
        JSONObject jsonObject = new JSONObject();
        try{
            supplierService.deleteFileById(id);
            jsonObject.accumulate("success", true);
        }catch(Exception e){
            e.printStackTrace();
            jsonObject.accumulate("success", false);
            jsonObject.accumulate("message", e.getMessage());
        }
        return jsonObject;
    }

    /**
     * 根据供应商id查询文件信息
     * @param supplierId 供应商id
     */
    @RequestMapping("selectFileBySupplierId")
    @ResponseBody
    @AnnotationLimit(pid="ee",mid="ea")
    public Map<String, Object> selectFileBySupplierId(String supplierId){
        Map<String, Object> map = new HashMap<>();
        try{
            map = supplierService.selectFileBySupplierId(supplierId);
            map.put("success", true);
        }catch(Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 新增供应商与物料的关联关系
     * @param supplierId 供应商id
     * @param material 物料id
     */
    @RequestMapping("insertSupplierAndMaterial")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eae")
    public Map<String, Object> insertSupplierAndMaterial(String supplierId,String material){
        return supplierService.insertSupplierAndMaterial(supplierId,material);

    }

    /**
     * 根据条件查询供应商关联的物料信息
     * @param materialQueryVo 条件
     */
    @RequestMapping("selectInfoBySupplierId")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="ead")
    public Map<String, Object> selectInfoBySupplierId(WarMaterialQueryVo materialQueryVo){
        return supplierService.selectInfoBySupplierId(materialQueryVo);
    }

    /**
     * 查询关联价格的物料
     * @param materialQueryVo 查询条件
     */
    @RequestMapping("findAllWarMaterialList")
    @ResponseBody
    @AnnotationLimit(mid="ea",pid="eae")
    public Object findAllWarMaterialList(WarMaterialQueryVo materialQueryVo){
        if (StringUtils.isNotBlank(materialQueryVo.getMaterialCodeForExpand())){
            return materialService.findAllWarMaterialList(materialQueryVo);
        }else{
            Map<String, Object> map = new HashMap<>();
            String total = materialService.findAllWarMaterialTotal(materialQueryVo);
            List<WarMaterial> list = materialService.findAllWarMaterialList(materialQueryVo);
            map.put("rows", list);
            map.put("total", total);
            map.put("query", materialQueryVo);
            return map;
        }
    }

    /**
     * 根据物料id删除关联的物料信息
     * @param materials 物料id集合
     */
    @RequestMapping("deleteBySupplierId")
    @ResponseBody
    @AnnotationLimit(pid="ea",mid="eaf")
    public Map<String, Object> deleteBySupplierId(String materials){
        return supplierService.deleteByMaterialId(materials);
    }

}
