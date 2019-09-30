package cn.chiucheung.service.purchase.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.purchase.material.PurMaterialBaseDataMapper;
import cn.chiucheung.po.purchase.material.PurMaterialBaseData;
import cn.chiucheung.po.purchase.material.PurMaterialBaseDataExample;
import cn.chiucheung.pojo.purchase.material.PurMaterialBaseDataCustom;
import cn.chiucheung.service.purchase.MaterialBaseDataService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class MaterialBaseDataServiceImpl implements MaterialBaseDataService{
	@Autowired
	PurMaterialBaseDataMapper materialBaseDataMapper;

	@Override
	public List<PurMaterialBaseData> findAllKeywordByDistinct() {
		List<PurMaterialBaseData> list = materialBaseDataMapper.findAllKeywordByDistinct();
		//id为空，combobox加载的时候会有错误
		for (int i=0;i<list.size();i++){
			list.get(i).setId(i+"");
		}
		return list;
	}


	@Override
	public List<PurMaterialBaseData> findAllPurMaterialBaseDataByKeyword(String keyword) {
		PurMaterialBaseDataExample materialBaseDataExample = new PurMaterialBaseDataExample();
		materialBaseDataExample.setOrderByClause("dictionarie_code");
		materialBaseDataExample.createCriteria().andKeywordEqualTo(keyword);
		return materialBaseDataMapper.selectByExample(materialBaseDataExample);
	}
	

	@Override
	public List<PurMaterialBaseDataCustom> findAllPurMaterialBaseDataByKeywordForDensity() {
		List<PurMaterialBaseData> materialBaseDatas = findAllPurMaterialBaseDataByKeyword("比重");
		List<PurMaterialBaseDataCustom> materialBaseDataCustoms = new ArrayList<PurMaterialBaseDataCustom>();
		for (PurMaterialBaseData materialBaseData : materialBaseDatas) {
			PurMaterialBaseDataCustom materialBaseDataCustom = new PurMaterialBaseDataCustom();
			materialBaseDataCustom.setDictionarieName(materialBaseData.getDictionarieName());
			materialBaseDataCustom.setDictionarieCode(findAllPurMaterialBaseDataByKeyword(materialBaseData.getDictionarieName()).get(0).getDictionarieName());
			materialBaseDataCustoms.add(materialBaseDataCustom);
		}
		return materialBaseDataCustoms;
	}

	@Override
	public int savePurMaterialBaseData(PurMaterialBaseData materialBaseData) {
		materialBaseData.setId(UUIDBuild.getUUID());
		return materialBaseDataMapper.insert(materialBaseData);
	}

	@Override
	public int updatePurMaterialBaseData(PurMaterialBaseData materialBaseData) {
		return materialBaseDataMapper.updateByPrimaryKey(materialBaseData);
	}

	@Override
	public int deletePurMaterialBaseDataById(String id) {
		return materialBaseDataMapper.deleteByPrimaryKey(id);
	}


}
