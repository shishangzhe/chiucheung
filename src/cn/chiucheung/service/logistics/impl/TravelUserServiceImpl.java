package cn.chiucheung.service.logistics.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.logistics.traveluser.LogTravelUserMapper;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.po.logistics.traveluser.LogTravelUserExample;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;
import cn.chiucheung.service.logistics.TravelUserService;
import cn.chiucheung.utils.MD5keyBean;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class TravelUserServiceImpl implements TravelUserService{
	
	@Autowired
	private LogTravelUserMapper travelUserMapper;
	

	@Override
	public List<LogTravelUser> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo) {
		return travelUserMapper.findAllTravelUserList(travelUserQueryVo);
	}
	
	@Override
	public String findAllTravelUserTotal(LogTravelUserQueryVo travelUserQueryVo) {
		return travelUserMapper.findAllTravelUserTotal(travelUserQueryVo);
	}
	
	@Override
	public int saveTravelUser(LogTravelUser travelUser) {
		MD5keyBean md5keyBean = new MD5keyBean();
		travelUser.setPassword(md5keyBean.getkeyBeanofStr(travelUser.getPassword()));
		travelUser.setId(UUIDBuild.getUUID());
		return travelUserMapper.insert(travelUser);
	}

	@Override
	public LogTravelUser findTravelUserById(String id) {
		LogTravelUser travelUser = travelUserMapper.selectByPrimaryKey(id);
		travelUser.setPassword("");
		return travelUser;
	}

	@Override
	public int updateTravelUser(LogTravelUser travelUser) {
		if (StringUtils.isNotBlank(travelUser.getPassword())){
			MD5keyBean md5keyBean = new MD5keyBean();
			travelUser.setPassword(md5keyBean.getkeyBeanofStr(travelUser.getPassword()));
		}else{
			travelUser.setPassword(null);
		}
		return travelUserMapper.updateByPrimaryKeySelective(travelUser);
		
	}

	@Override
	public int deleteTravelUserById(String id) {
		return travelUserMapper.deleteByPrimaryKey(id);
	}
	


	@Override
	public int deleteDeviceSerialNumberById(String id) {
		LogTravelUser travelUser = travelUserMapper.selectByPrimaryKey(id);
		travelUser.setDeviceSerialNumber(null);
		return travelUserMapper.updateByPrimaryKey(travelUser);
	}

	@Override
	public List<LogTravelUser> findTravelUserByWorkNoAndPassword(LogTravelUser travelUser) {
		//MD5keyBean md5keyBean = new MD5keyBean();
		//travelUser.setPassword(md5keyBean.getkeyBeanofStr(travelUser.getPassword()));
		return travelUserMapper.findTravelUserByWorkNoAndPassword(travelUser);
	}

	@Override
	public List<LogTravelUser> findAllTravelUserByUsername(String username) {
		LogTravelUserExample travelUserExample = new LogTravelUserExample();
		travelUserExample.createCriteria().andUsernameEqualTo(username);
		return travelUserMapper.selectByExample(travelUserExample);
	}

	@Override
	public List<LogTravelUser> findAllTravelUserByWorkNo(String workNo) {
		LogTravelUserExample travelUserExample = new LogTravelUserExample();
		travelUserExample.createCriteria().andWorkNoEqualTo(workNo);
		return travelUserMapper.selectByExample(travelUserExample);
	}
	
	@Override
	public int updateTravelUserByAppChangePassowrd(LogTravelUser travelUser) {
		LogTravelUserExample travelUserExample = new LogTravelUserExample();
		travelUserExample.createCriteria().andWorkNoEqualTo(travelUser.getWorkNo());
		MD5keyBean md5keyBean = new MD5keyBean();
		travelUser.setPassword(md5keyBean.getkeyBeanofStr(travelUser.getPassword()));
		return travelUserMapper.updateByExampleSelective(travelUser, travelUserExample);
	}
}
