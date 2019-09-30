package cn.chiucheung.dao.mapper.sales.reviewer;

import cn.chiucheung.po.sales.reviewer.SalReviewer;
import cn.chiucheung.po.sales.reviewer.SalReviewerExample;
import cn.chiucheung.po.sales.reviewer.SalReviewerWithBLOBs;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalReviewerMapper {
    int countByExample(SalReviewerExample example);

    int deleteByExample(SalReviewerExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalReviewerWithBLOBs record);

    int insertSelective(SalReviewerWithBLOBs record);

    List<SalReviewerWithBLOBs> selectByExampleWithBLOBs(SalReviewerExample example);

    List<SalReviewer> selectByExample(SalReviewerExample example);

    SalReviewerWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalReviewerWithBLOBs record, @Param("example") SalReviewerExample example);

    int updateByExampleWithBLOBs(@Param("record") SalReviewerWithBLOBs record, @Param("example") SalReviewerExample example);

    int updateByExample(@Param("record") SalReviewer record, @Param("example") SalReviewerExample example);

    int updateByPrimaryKeySelective(SalReviewerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SalReviewerWithBLOBs record);

    int updateByPrimaryKey(SalReviewer record);
    
    List<SalReviewerCustom> findAllSalReviewerList(SalReviewerQueryVo reviewerQueryVo);
    
    String findAllSalReviewerListTotal(SalReviewerQueryVo reviewerQueryVo);
    
    /**
     * 根据查询条件查询已完成的项目评审表-成本核算，用于成本核算关联
     * @param reviewerVo
     * @return
     */
	List<SalReviewerCustom> findCompleteReviewerCostCollect(SalReviewerQueryVo reviewerQueryVo);
}