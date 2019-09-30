package cn.chiucheung.service.system;

import java.util.List;

import cn.chiucheung.po.system.map.SysMapLli;
import cn.chiucheung.pojo.system.map.SysMapLliQueryVo;

public interface MapLliService {
	
	/**
	 * 查找所有的地图经纬度
	 * @param mapLliQueryVo
	 * @return
	 */
	List<SysMapLli> findAllMapLliList(SysMapLliQueryVo mapLliQueryVo);
	
	/**
	 * 查找所有的地图经纬度的总数
	 * @param mapLliQueryVo
	 * @return
	 */
	String findAllMapLliTotal(SysMapLliQueryVo mapLliQueryVo);
	
	/**
	 * 对地图名称进行查找，是否存在，用于前台校验
	 * @param mapLli
	 * @return
	 */
	List<SysMapLli> checkMapNameIsRepeat(SysMapLli mapLli);

	/**
	 * 新增地图经纬度
	 * @param mapLli
	 * @return
	 */
	int saveSysMapLli(SysMapLli mapLli);

	/**
	 * 根据id查找地图经纬度，用于页面编辑
	 * @param id
	 * @return
	 */
	SysMapLli findSysMapLliById(String id);
	
	/**
	 * 更新地图经纬度
	 * @param mapLli
	 * @return
	 */
	int updateSysMapLli(SysMapLli mapLli);
	
	/**
	 * 删除地图经纬度
	 * @param id
	 * @return
	 */
	int deleteSysMapLliById(String id);

}
