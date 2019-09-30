package cn.chiucheung.dao.mapper.finance.checksheet;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.finance.checksheet.FinCheckSheet;
import cn.chiucheung.po.finance.checksheet.FinCheckSheetExample;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetQueryVo;

public interface FinCheckSheetMapper {
    int countByExample(FinCheckSheetExample example);

    int deleteByExample(FinCheckSheetExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinCheckSheet record);

    int insertSelective(FinCheckSheet record);

    List<FinCheckSheet> selectByExample(FinCheckSheetExample example);

    FinCheckSheet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinCheckSheet record, @Param("example") FinCheckSheetExample example);

    int updateByExample(@Param("record") FinCheckSheet record, @Param("example") FinCheckSheetExample example);

    int updateByPrimaryKeySelective(FinCheckSheet record);

    int updateByPrimaryKey(FinCheckSheet record);
    
	int findMaxCheckSheetNo(@Param("checkSheetNo") String checkSheetNo);

	List<FinCheckSheetCustom> findAllCheckSheetList(FinCheckSheetQueryVo checkSheetQueryVo);

	String findAllCheckSheetTotal(FinCheckSheetQueryVo checkSheetQueryVo);

	FinCheckSheet findFinCheckSheetById(String id);
}