package cn.chiucheung.dao.mapper.market.conductpropagandafile;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFileExample;
import cn.chiucheung.pojo.market.conductpropagandafile.MarConductPropagandaFileQueryVo;

public interface MarConductPropagandaFileMapper {
    int countByExample(MarConductPropagandaFileExample example);

    int deleteByExample(MarConductPropagandaFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarConductPropagandaFile record);

    int insertSelective(MarConductPropagandaFile record);

    List<MarConductPropagandaFile> selectByExample(MarConductPropagandaFileExample example);

    MarConductPropagandaFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarConductPropagandaFile record, @Param("example") MarConductPropagandaFileExample example);

    int updateByExample(@Param("record") MarConductPropagandaFile record, @Param("example") MarConductPropagandaFileExample example);

    int updateByPrimaryKeySelective(MarConductPropagandaFile record);

    int updateByPrimaryKey(MarConductPropagandaFile record);

	List<MarConductPropagandaFile> findAllConductPropagandaFile(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo);

	String findAllConductPropagandaFileTotal(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo);

	List<MarConductPropagandaFile> findConductPropagandaFileList();
}