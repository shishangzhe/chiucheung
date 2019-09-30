package cn.chiucheung.dao.mapper.finance.workcardinfo;

import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfoExample;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForUpdateCustom;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForGenerateExcel;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoQueryVo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FinWorkCardInfoMapper {
    int countByExample(FinWorkCardInfoExample example);

    int deleteByExample(FinWorkCardInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinWorkCardInfo record);

    int insertSelective(FinWorkCardInfo record);

    List<FinWorkCardInfo> selectByExample(FinWorkCardInfoExample example);

    FinWorkCardInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinWorkCardInfo record, @Param("example") FinWorkCardInfoExample example);

    int updateByExample(@Param("record") FinWorkCardInfo record, @Param("example") FinWorkCardInfoExample example);

    int updateByPrimaryKeySelective(FinWorkCardInfo record);

    int updateByPrimaryKey(FinWorkCardInfo record);

	List<FinWorkCardInfoForUpdateCustom> findAllWorkCardInfoList(FinWorkCardInfoQueryVo workCardInfoQueryVo);

	String findAllWorkCardInfoTotal(FinWorkCardInfoQueryVo workCardInfoQueryVo);

	FinWorkCardInfo findWorkCardInfoById(FinWorkCardInfoQueryVo workCardInfoQueryVo);

	int updateWorkCardInfo(FinWorkCardInfoForUpdateCustom workCardInfoForUpdateCustom);

	List<FinWorkCardInfoForGenerateExcel> FindAllCompletionWorkCardCostForGenerateExcel(FinWorkCardInfoQueryVo workCardInfoQueryVo);

	BigDecimal calculationTrafficCostInInstallationPersonnel(FinWorkCardInfoForGenerateExcel workCardInfoForGenerateExcel);

	int insertList(List<FinWorkCardInfo> list);
}