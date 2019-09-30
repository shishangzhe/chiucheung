package cn.chiucheung.dao.mapper.market.exhibitioncontact;

import cn.chiucheung.po.market.exhibitioncontact.MarExhibitionContact;
import cn.chiucheung.po.market.exhibitioncontact.MarExhibitionContactExample;
import cn.chiucheung.pojo.market.exhibitioncontact.MarExhibitionContactQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MarExhibitionContactMapper {
    int countByExample(MarExhibitionContactExample example);

    int deleteByExample(MarExhibitionContactExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarExhibitionContact record);

    int insertSelective(MarExhibitionContact record);

    List<MarExhibitionContact> selectByExample(MarExhibitionContactExample example);

    MarExhibitionContact selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarExhibitionContact record, @Param("example") MarExhibitionContactExample example);

    int updateByExample(@Param("record") MarExhibitionContact record, @Param("example") MarExhibitionContactExample example);

    int updateByPrimaryKeySelective(MarExhibitionContact record);

    int updateByPrimaryKey(MarExhibitionContact record);

	List<MarExhibitionContact> findAllExhibitionContactList(MarExhibitionContactQueryVo exhibitionContactQueryVo);

	String findAllExhibitionContactTotal(MarExhibitionContactQueryVo exhibitionContactQueryVo);
}