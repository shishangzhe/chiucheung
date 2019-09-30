package cn.chiucheung.service.engineering;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.engineering.workhours.EngWorkHours;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.workhours.EngExportResultsExcelCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursVo;

public interface WorkHoursService {
	
	/**
	 * 新增工时
	 * @param engWorkHours
	 * @return
	 */
	int saveEngWorkHours(EngWorkHoursCustom workHoursCustom) throws Exception;
	
	/**
	 * 查找所有的工时
	 * @param workHoursVo 查询的条件
	 * @return
	 */
	List<EngWorkHours> findAllWorkHoursList(EngWorkHoursVo workHoursVo);

	/**
	 * 查询总记录数
	 * @param workHoursVo 查询的条件
	 * @return
	 */
	String findAllWorkHoursTotal(EngWorkHoursVo workHoursVo);
	
	/**
	 * 计算工时综合
	 * @param workHoursVo 查询的条件
	 * @return
	 */
	String findAllWorkHoursSum(EngWorkHoursVo workHoursVo);
	
	/**
	 * 根据id查询工时，用于修改的数据展示
	 * @param id 查询的条件
	 * @return
	 */
	EngWorkHoursCustom findEngWorkHoursById(String id) throws Exception;
	
	/**
	 * 更新工时
	 * @param engWorkHours
	 * @return
	 */
	int updateEngWorkHours(EngWorkHoursCustom workHoursCustom) throws Exception;
	
	/**
	 * 根据id删除工时
	 * @param id
	 * @return
	 */
	int deleteEngWorkHoursById(String id);
	
	/**
	 * 根据日期和班次检查剩余时间
	 * @param workHours
	 * @return
	 */
	String checkRemainingTime(EngWorkHours workHours, HttpSession session);
	
	/**
	 * 导出施工成绩表
	 * @param workHoursVo
	 * @return
	 */
	List<EngExportResultsExcelCustom> exportResultsExcel1(EngWorkHoursVo workHoursVo);
	
	/**
	 * 导出工时分布表
	 * @param workHoursVo
	 * @return
	 */
	List<EngExportResultsExcelCustom> exportResultsExcel2(EngWorkHoursVo workHoursVo);
	
	/**
	 * 导出工咭工时统计表
	 * @param workHoursVo
	 * @return
	 */
	List<EngExportResultsExcelCustom> exportResultsExcel3(EngWorkHoursVo workHoursVo);
	
	/**
	 * 导出实做工咭工时分析
	 * @param workHoursVo
	 * @return
	 */
	List<EngExportResultsExcelCustom> exportResultsExcel4(EngWorkHoursVo workHoursVo);

	/**
	 * 导出月工咭产值结算表
	 * @param workHoursVo
	 * @return
	 */
	List<EngExportResultsExcelCustom> exportResultsExcel5(EngWorkHoursVo workHoursVo);

	/**
	 * 查找各个组的技术主任
	 * @return
	 */
	List<SysUser> selectEngReviewer();

}
