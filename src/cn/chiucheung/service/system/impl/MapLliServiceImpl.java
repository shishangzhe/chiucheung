package cn.chiucheung.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.system.map.SysMapLliMapper;
import cn.chiucheung.po.system.map.SysMapLli;
import cn.chiucheung.po.system.map.SysMapLliExample;
import cn.chiucheung.po.system.map.SysMapLliExample.Criteria;
import cn.chiucheung.pojo.system.map.SysMapLliQueryVo;
import cn.chiucheung.service.system.MapLliService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class MapLliServiceImpl implements MapLliService{
	
	@Autowired SysMapLliMapper mapLliMapper;

	@Override
	public List<SysMapLli> findAllMapLliList(SysMapLliQueryVo mapLliQueryVo) {
		return mapLliMapper.findAllMapLliList(mapLliQueryVo);
	}

	@Override
	public String findAllMapLliTotal(SysMapLliQueryVo mapLliQueryVo) {
		return mapLliMapper.findAllMapLliTotal(mapLliQueryVo);
	}

	@Override
	public List<SysMapLli> checkMapNameIsRepeat(SysMapLli mapLli) {
		SysMapLliExample example = new SysMapLliExample();
		Criteria criteria = example.createCriteria();
		if (mapLli.getName() != null){
			criteria.andNameEqualTo(mapLli.getName());
		}else if (mapLli.getEngName() != null){
			criteria.andEngNameEqualTo(mapLli.getEngName());
		}
		return mapLliMapper.selectByExample(example);
	}

	@Override
	public int saveSysMapLli(SysMapLli mapLli) {
		mapLli.setId(UUIDBuild.getUUID());
		return mapLliMapper.insert(mapLli);
	}

	@Override
	public SysMapLli findSysMapLliById(String id) {
		return mapLliMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateSysMapLli(SysMapLli mapLli) {
		return mapLliMapper.updateByPrimaryKey(mapLli);
	}

	@Override
	public int deleteSysMapLliById(String id) {
		return mapLliMapper.deleteByPrimaryKey(id);
	}
}
