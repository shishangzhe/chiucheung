package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardFile;
import cn.chiucheung.po.sales.workcard.SalWorkCardFileExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalWorkCardFileMapper {
    int countByExample(SalWorkCardFileExample example);

    int deleteByExample(SalWorkCardFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardFile record);

    int insertSelective(SalWorkCardFile record);

    List<SalWorkCardFile> selectByExample(SalWorkCardFileExample example);

    SalWorkCardFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardFile record, @Param("example") SalWorkCardFileExample example);

    int updateByExample(@Param("record") SalWorkCardFile record, @Param("example") SalWorkCardFileExample example);

    int updateByPrimaryKeySelective(SalWorkCardFile record);

    int updateByPrimaryKey(SalWorkCardFile record);

	List<SalWorkCardFile> findWorkCardFileListBySalWorkCardId(String workCardId);
}