package cn.chiucheung.service.production;

import java.util.List;

import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.pojo.production.standard.ProProcessTreegridCustom;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;

public interface ProcessService {

	/**
	 * 获取所有的生产工序表
	 * @return 返回ProProcess的list
	 */
	List<ProProcess> findAllProProcessList(ProProcessQueryVo processQueryVo);

	/**
	 * 新增生产工序
	 * @param proProcess 要添加的生产工序
	 * @return 新增的条数
	 */
	int saveProProcess(ProProcess process);	
	
	/**
	 * 根据id查找生产工序
	 * @param id 查询条件的id
	 * @return 返回查找到的生产工序
	 */
	ProProcess findProProcessById(String id);

	/**
	 * 修改生产工序
	 * @param process 要修改的生产工序
	 * @return 修改的条数
	 */
	int updateProProcess(ProProcess process);	
	
	/**
	 * 删除生产工序
	 * @param id 要删除的生产工序ID
	 * @return 批量删除的条数
	 */	
	int deleteProProcessById(String id);
	
	/**
	 * 查找所有的工序，去除重复
	 * @return
	 */
	List<ProProcess> findAllProcessByDistinct();
	
	/**
	 * 为combotreegrid加载数据
	 * @param parentProcessNumber
	 * @return
	 */
	List<ProProcessTreegridCustom> findAllProProcessListForCombotreegrid(ProProcessQueryVo processQueryVo);


}
