package cn.chiucheung.service.purchase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.purchase.material.PurMaterialMapper;
import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;
import cn.chiucheung.service.purchase.MaterialService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired PurMaterialMapper materialMapper;

	@Override
	public List<PurMaterial> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo) {
		return materialMapper.findAllPurMaterialList(materialQueryVo);
	}
	
	@Override
	public String findAllPurMaterialTotal(PurMaterialQueryVo materialQueryVo) {
		return materialMapper.findAllPurMaterialTotal(materialQueryVo);
	}
	
	@Override
	public int savePurMaterial(PurMaterial material) {
		material.setId(UUIDBuild.getUUID());
		return materialMapper.insertSelective(material);
	}

	@Override
	public PurMaterial findPurMaterialById(String id) {
		return materialMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updatePurMaterial(PurMaterial material) {
		/*if (material.getThick() != null && material.getLength() != null && material.getWidth() != null && material.getDensity() != null){
			float thick = material.getThick();
			int length = material.getLength();
			int width = material.getWidth();
			float density = material.getDensity();
			float weight = thick*length*width*density/1000000;
			BigDecimal bigDecimal = new BigDecimal(weight);
			bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			material.setWeight(bigDecimal.floatValue());
		}*/
		return materialMapper.updateByPrimaryKey(material);
	}

	@Override
	public int deletePurMaterialById(String id) {
		return materialMapper.deleteByPrimaryKey(id);
	}


}
