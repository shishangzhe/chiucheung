package cn.chiucheung.service.purchase;

import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.purchase.supplier.PurSupplier;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierCustomer;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierQueryVo;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SupplierService {

    /**
     * 根据id查询供应商及其附属文件信息
     * @param supplierId id
     */
    Map<String, Object> selectSupplierById(String supplierId);

    /**
     * 根据条件获取供应商信息
     * @param purSupplierQueryVo 所需条件
     * @return 供应商信息
     */
    List<PurSupplierCustomer> selectSupplierList(PurSupplierQueryVo purSupplierQueryVo);

    /**
     * 根据条件获取供应商数量
     * @param purSupplierQueryVo 所需条件
     * @return 供应商数量
     */
    String selectSupplierCount(PurSupplierQueryVo purSupplierQueryVo);

    /**
     * 新增供应商信息
     * @param purSupplier 基本信息
     * @param businessLicenseFile 营业执照图片信息
     * @param registeredTrademarkFile 注册商标图片信息
     */
    Map<String, Object> insertSupplier(PurSupplier purSupplier, MultipartFile[] businessLicenseFile, MultipartFile[] registeredTrademarkFile) throws IOException;

    /**
     * 修改供应商信息
     * @param purSupplier 基本信息
     * @param businessLicenseFile 营业执照图片信息
     * @param registeredTrademarkFile 注册商标图片信息
     * @return
     */
    Map<String, Object> updateSupplier(PurSupplier purSupplier,MultipartFile[] businessLicenseFile,MultipartFile[] registeredTrademarkFile) throws IOException;

    /**
     * 根据id删除信息
     * @param supplierId 供应商id
     */
    Map<String, Object> deleteSupplier(String supplierId) throws Exception;

    /**
     * 根据文件id删除文件
     * @param id 文件id
     */
    int deleteFileById(String id);

    /**
     * 根据供应商id查询文件信息
     * @param supplierId 供应商id
     */
    Map<String, Object> selectFileBySupplierId(String supplierId);


    /**
     * 新增供应商与物料的关联关系
     * @param supplierId 供应商id
     * @param material 物料id
     */
    Map<String, Object> insertSupplierAndMaterial(String supplierId,String material);

    /**
     * 根据条件查询供应商关联的物料信息
     * @param materialQueryVo 条件
     */
    Map<String, Object> selectInfoBySupplierId(WarMaterialQueryVo materialQueryVo);

    /**
     * 根据物料id删除关联的物料
     * @param materials 物料id集合
     */
    Map<String, Object> deleteByMaterialId(String materials);

}
