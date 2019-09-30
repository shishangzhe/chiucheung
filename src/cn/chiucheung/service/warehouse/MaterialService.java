package cn.chiucheung.service.warehouse;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

public interface MaterialService {

	/**
	 * 根据条件查找所有的物料
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo);

	/**
	 * 根据条件查找所有的物料的记录总数
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo);

	/**
	 * 新增物料
	 * @param material
	 * @param attachment
	 * @return 返回上级分组的id，用于页面刷新该分组
	 */
	String saveMaterial(WarMaterial material, MultipartFile attachment) throws Exception;

	/**
	 * 根据id查找物料，用于页面的修改
	 * @param id
	 * @return
	 */
	WarMaterial findMaterialByIdForEdit(String id);
	
	/**
	 * 根据物料附件id查找物料附件
	 * @param id
	 * @return
	 */
	WarMaterialFile findMaterialFileById(String id);

	/**
	 * 根据物料id查找物料附件
	 * @param id
	 * @return
	 */
	WarMaterialFile findMaterialFileByWarMaterialId(String id);

	/**
	 * 更新物料
	 * @param material
	 * @param attachment
	 * @return 返回上级分组的id，用于页面刷新该分组
	 */
	String updateWarMaterial(WarMaterial material, MultipartFile attachment) throws Exception;

	/**
	 * 根据materialFile的id删除WarMaterialFile
	 * @param id
	 * @return
	 */
	int deleteWarMaterialFileById(String id);


	/**
	 * 根据id删除物料
	 * @param id
	 * @param session
	 * @return
	 */
	int deleteWarMaterialById(String id);
}
