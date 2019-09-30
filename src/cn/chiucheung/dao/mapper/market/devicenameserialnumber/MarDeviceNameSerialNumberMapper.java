package cn.chiucheung.dao.mapper.market.devicenameserialnumber;

import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumber;
import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumberExample;
import cn.chiucheung.pojo.market.devicenameserialnumber.MarDeviceNameSerialNumberQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MarDeviceNameSerialNumberMapper {
    int countByExample(MarDeviceNameSerialNumberExample example);

    int deleteByExample(MarDeviceNameSerialNumberExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarDeviceNameSerialNumber record);

    int insertSelective(MarDeviceNameSerialNumber record);

    List<MarDeviceNameSerialNumber> selectByExample(MarDeviceNameSerialNumberExample example);

    MarDeviceNameSerialNumber selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarDeviceNameSerialNumber record, @Param("example") MarDeviceNameSerialNumberExample example);

    int updateByExample(@Param("record") MarDeviceNameSerialNumber record, @Param("example") MarDeviceNameSerialNumberExample example);

    int updateByPrimaryKeySelective(MarDeviceNameSerialNumber record);

    int updateByPrimaryKey(MarDeviceNameSerialNumber record);

	List<MarDeviceNameSerialNumber> findAllDeviceNameSerialNumber(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo);

	String findAllDeviceNameSerialNumberTotal(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo);
}