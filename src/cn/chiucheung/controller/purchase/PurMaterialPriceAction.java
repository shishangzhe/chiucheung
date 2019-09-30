package cn.chiucheung.controller.purchase;


import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.purchase.MaterialPriceService;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.FileUtils;
import cn.chiucheung.utils.ResourcesUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchase/materialPrice")
public class PurMaterialPriceAction {

    @Autowired
    private MaterialPriceService materialPriceService;
    @Autowired
    private MaterialService materialService;


    @RequestMapping("index")
    @AnnotationLimit(mid="eb",pid="ee")
    public String price(){
        return "purchase/materialPrice";
    }

    /**
     * 新增物料价格
     * @param price 价格
     */
    @RequestMapping("insertPrice")
    @ResponseBody
    @AnnotationLimit(pid="eb",mid="eba")
    public Map<String, Object> insertPrice(WarMaterialPrice price){
        return materialPriceService.insertPrice(price);
    }

    /**
     * 根据物料id获取价格
     * @param materialId 物料id
     */
    @RequestMapping("selectPriceByMaterialId")
    @ResponseBody
    @AnnotationLimit(mid="eb",pid="ee")
    public Map<String, Object> selectPriceByMaterialId(String materialId){
        return materialPriceService.selectPriceByMaterialId(materialId);
    }

    /**
     * 根据物料id修改物料价格
     * @param price 物料价格信息(包括物料id)
     */
    @RequestMapping("updatePriceByMaterialId")
    @ResponseBody
    @AnnotationLimit(pid="eb",mid="ebb")
    public Map<String, Object> updatePriceByMaterialId(WarMaterialPrice price){
        return materialPriceService.updatePriceByMaterialId(price);
    }

    /**
     * 根据物料文件id查询物料附属文件
     * @param id 物料文件Id
     */
    @RequestMapping("readFileById")
    @ResponseBody
    @AnnotationLimit(mid="eb",pid="ee")
    public void readFileById(String id, HttpServletResponse response){
        WarMaterialFile materialFile = materialService.findMaterialFileById(id);
        File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material",materialFile.getFilePath());
        FileUtils.downloadFile(response, file);
    }

    /**
     * 查询关联价格的物料
     * @param materialQueryVo 查询条件
     */
    @RequestMapping("findAllWarMaterialList")
    @ResponseBody
    @AnnotationLimit(mid="eb",pid="ee")
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
     * 多条更新关联物料的价格
     * @param materialIdList 关联物料id的集合
     */
    @RequestMapping("updateStatue")
    @ResponseBody
    @AnnotationLimit(pid="eb",mid="ebc")
    public Object updateStatue(String materialIdList){
        return materialPriceService.updateStatue(materialIdList);
    }


}
