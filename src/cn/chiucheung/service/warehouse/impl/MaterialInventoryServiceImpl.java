package cn.chiucheung.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.warehouse.materialinventory.WarMaterialInventoryMapper;
import cn.chiucheung.pojo.warehouse.material.WarMaterialInventoryCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.warehouse.MaterialInventoryService;

@Service
public class MaterialInventoryServiceImpl implements MaterialInventoryService{
	
	@Autowired
	private WarMaterialInventoryMapper materialInventoryMapper;

	@Override
	public List<WarMaterialInventoryCustom> findAllWarMaterialInventoryList(WarMaterialQueryVo materialQueryVo) {
		return materialInventoryMapper.findAllWarMaterialInventoryList(materialQueryVo);
	}

	@Override
	public String findAllWarMaterialInventoryTotal(WarMaterialQueryVo materialQueryVo) {
		return materialInventoryMapper.findAllWarMaterialInventoryTotal(materialQueryVo);
	}
	
}
