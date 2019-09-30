package cn.chiucheung.dao.mapper.engineering.workhours;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.engineering.workhours.EngWorkHours;
import cn.chiucheung.po.engineering.workhours.EngWorkHoursExample;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.workhours.EngExportResultsExcelCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursVo;

public interface EngWorkHoursMapper {
    int countByExample(EngWorkHoursExample example);

    int deleteByExample(EngWorkHoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(EngWorkHours record);

    int insertSelective(EngWorkHours record);

    List<EngWorkHours> selectByExampleWithBLOBs(EngWorkHoursExample example);

    List<EngWorkHours> selectByExample(EngWorkHoursExample example);

    EngWorkHours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EngWorkHours record, @Param("example") EngWorkHoursExample example);

    int updateByExampleWithBLOBs(@Param("record") EngWorkHours record, @Param("example") EngWorkHoursExample example);

    int updateByExample(@Param("record") EngWorkHours record, @Param("example") EngWorkHoursExample example);

    int updateByPrimaryKeySelective(EngWorkHours record);

    int updateByPrimaryKeyWithBLOBs(EngWorkHours record);

    int updateByPrimaryKey(EngWorkHours record);

	List<EngWorkHours> findAllWorkHoursList(EngWorkHoursVo workHoursVo);

	EngWorkHoursCustom findEngWorkHoursById(String id);

	String checkRemainingTime(EngWorkHours workHours);

	String findAllWorkHoursTotal(EngWorkHoursVo workHoursVo);

	String findAllWorkHoursSum(EngWorkHoursVo workHoursVo);

	List<EngExportResultsExcelCustom> exportResultsExcel1(EngWorkHoursVo workHoursVo);

	List<EngExportResultsExcelCustom> exportResultsExcel2(EngWorkHoursVo workHoursVo);

	List<EngExportResultsExcelCustom> exportResultsExcel3(EngWorkHoursVo workHoursVo);

	List<EngExportResultsExcelCustom> exportResultsExcel4(EngWorkHoursVo workHoursVo);

	List<EngExportResultsExcelCustom> exportResultsExcel5(EngWorkHoursVo workHoursVo);

	List<SysUser> selectEngReviewer();
}