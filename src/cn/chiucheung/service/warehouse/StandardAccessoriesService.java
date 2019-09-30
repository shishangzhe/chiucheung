package cn.chiucheung.service.warehouse;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

public interface StandardAccessoriesService {
	
	/**
	 * 新增标准配件
	 * @param standardAccessories
	 * @param attachment 附件
	 * @return
	 */
	int saveWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment) throws Exception;
	
	/**
	 * 根据条件查找所有的标准配件
	 * @return
	 */
	List<WarStandardAccessoriesCustom> findAllWarStandardAccessoriesList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 根据条件查找所有标准配件的总数
	 * @return
	 */
	String findAllWarStandardAccessoriesTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 根据id查找标准配件
	 * @param id
	 * @return
	 */
	WarStandardAccessories findWarStandardAccessoriesByIdForEdit(String id);
	
	/**
	 * 根据standardAccessoriesFile的id删除WarStandardAccessoriesFile
	 * @param id
	 * @return
	 */
	int deleteWarStandardAccessoriesFileById(String id);
	
	/**
	 * 根据warStandardAccessoriesId查找WarStandardAccessoriesFile
	 * @param warStandardAccessoriesId
	 * @return
	 */
	WarStandardAccessoriesFile findWarStandardAccessoriesFileByWarStandardAccessoriesId(String warStandardAccessoriesId);
	
	/**
	 * 更新标准配件
	 * @param standardAccessories
	 * @param session 
	 * @param attachment 
	 * @return
	 */
	int updateWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment) throws Exception;
	
	/**
	 * 根据id删除标准配件
	 * @param id
	 * @return
	 */
	int deleteWarStandardAccessoriesById(String id);
	
	/**
	 * 根据id查找WarStandardAccessoriesFile
	 * @param id
	 * @return
	 */
	WarStandardAccessoriesFile findfindWarStandardAccessoriesFileById(String id);

}
