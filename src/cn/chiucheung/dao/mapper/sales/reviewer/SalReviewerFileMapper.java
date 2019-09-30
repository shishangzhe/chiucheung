package cn.chiucheung.dao.mapper.sales.reviewer;

import cn.chiucheung.po.sales.reviewer.SalReviewerFile;
import cn.chiucheung.po.sales.reviewer.SalReviewerFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalReviewerFileMapper {
    int countByExample(SalReviewerFileExample example);

    int deleteByExample(SalReviewerFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalReviewerFile record);

    int insertSelective(SalReviewerFile record);

    List<SalReviewerFile> selectByExample(SalReviewerFileExample example);

    SalReviewerFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalReviewerFile record, @Param("example") SalReviewerFileExample example);

    int updateByExample(@Param("record") SalReviewerFile record, @Param("example") SalReviewerFileExample example);

    int updateByPrimaryKeySelective(SalReviewerFile record);

    int updateByPrimaryKey(SalReviewerFile record);
    
    int insertList(List<SalReviewerFile> list);
}