package cn.chiucheung.service.market;

import java.util.List;

import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumber;
import cn.chiucheung.pojo.market.devicenameserialnumber.MarDeviceNameSerialNumberQueryVo;

public interface DeviceNameSerialNumberService {
	
	/**
	 * 查找所有的设备
	 * @param deviceNameSerialNumberQueryVo
	 * @return
	 */
	List<MarDeviceNameSerialNumber> findAllDeviceNameSerialNumber(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo);
	
	/**
	 * 查找所有的设备的数量
	 * @param deviceNameSerialNumberQueryVo
	 * @return
	 */
	String findAllDeviceNameSerialNumberTotal(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo);
	
	/**
	 * 新增设备
	 * @param deviceNameSerialNumber
	 * @return
	 */
	int saveDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber);
	
	/**
	 * 根据id查找设备
	 * @param id
	 * @return
	 */
	MarDeviceNameSerialNumber findDeviceNameSerialNumberById(String id);
	
	/**
	 * 更新设备
	 * @param deviceNameSerialNumber
	 * @return
	 */
	int updateDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber);
	
	/**
	 * 根据id删除设备
	 * @param id
	 * @return
	 */
	int deleteDeviceNameSerialNumberById(String id);
	
	/**
	 * 根据serialNumber查找设备表
	 * @param serialNumber
	 * @return
	 */
	List<MarDeviceNameSerialNumber> checkSerialNumber(String serialNumber);

}
