package cn.chiucheung.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventoryMapper;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.warehouse.StandardAccessoriesInventoryService;

@Service
public class StandardAccessoriesInventoryServiceImpl implements StandardAccessoriesInventoryService{
	
	@Autowired
	private WarStandardAccessoriesInventoryMapper standardAccessoriesInventoryMapper;

	@Override
	public List<WarStandardAccessoriesInventoryCustom> findAllWarStandardAccessoriesInventoryList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return standardAccessoriesInventoryMapper.findAllWarStandardAccessoriesInventoryList(standardAccessoriesQueryVo);
	}

	@Override
	public String findAllWarStandardAccessoriesInventoryTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return standardAccessoriesInventoryMapper.findAllWarStandardAccessoriesInventoryTotal(standardAccessoriesQueryVo);
	}

}
