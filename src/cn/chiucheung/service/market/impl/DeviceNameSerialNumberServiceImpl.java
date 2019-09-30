package cn.chiucheung.service.market.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.market.devicenameserialnumber.MarDeviceNameSerialNumberMapper;
import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumber;
import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumberExample;
import cn.chiucheung.pojo.market.devicenameserialnumber.MarDeviceNameSerialNumberQueryVo;
import cn.chiucheung.service.market.DeviceNameSerialNumberService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class DeviceNameSerialNumberServiceImpl implements DeviceNameSerialNumberService{
	
	@Autowired
	MarDeviceNameSerialNumberMapper deviceNameSerialNumberMapper;

	@Override
	public List<MarDeviceNameSerialNumber> findAllDeviceNameSerialNumber(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo) {
		return deviceNameSerialNumberMapper.findAllDeviceNameSerialNumber(deviceNameSerialNumberQueryVo);
	}

	@Override
	public String findAllDeviceNameSerialNumberTotal(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo) {
		return deviceNameSerialNumberMapper.findAllDeviceNameSerialNumberTotal(deviceNameSerialNumberQueryVo);
	}

	@Override
	public int saveDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber) {
		deviceNameSerialNumber.setId(UUIDBuild.getUUID());
		return deviceNameSerialNumberMapper.insert(deviceNameSerialNumber);
	}

	@Override
	public MarDeviceNameSerialNumber findDeviceNameSerialNumberById(String id) {
		return deviceNameSerialNumberMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber) {
		return deviceNameSerialNumberMapper.updateByPrimaryKey(deviceNameSerialNumber);
	}

	@Override
	public int deleteDeviceNameSerialNumberById(String id) {
		return deviceNameSerialNumberMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<MarDeviceNameSerialNumber> checkSerialNumber(String serialNumber) {
		MarDeviceNameSerialNumberExample deviceNameSerialNumberExample = new MarDeviceNameSerialNumberExample();
		deviceNameSerialNumberExample.createCriteria().andSerialNumberEqualTo(serialNumber);
		return deviceNameSerialNumberMapper.selectByExample(deviceNameSerialNumberExample);
	}

}
