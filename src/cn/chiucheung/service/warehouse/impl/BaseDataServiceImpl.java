package cn.chiucheung.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.warehouse.basedata.WarBaseDataMapper;
import cn.chiucheung.po.warehouse.basedata.WarBaseData;
import cn.chiucheung.po.warehouse.basedata.WarBaseDataExample;
import cn.chiucheung.service.warehouse.BaseDataService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class BaseDataServiceImpl implements BaseDataService{
	
	@Autowired
	WarBaseDataMapper baseDataMapper;

	@Override
	public List<WarBaseData> findAllKeywordByDistinct() {
		List<WarBaseData> list = baseDataMapper.findAllKeywordByDistinct();
		//id为空，combobox加载的时候会有错误
		for (int i=0;i<list.size();i++){
			list.get(i).setId(i+"");
		}
		return list;
	}

	@Override
	public List<WarBaseData> findAllWarBaseDataByKeyword(String keyword) {
		WarBaseDataExample baseDataExample = new WarBaseDataExample();
		baseDataExample.setOrderByClause("dictionarie_code");
		baseDataExample.createCriteria().andKeywordEqualTo(keyword);
		return baseDataMapper.selectByExample(baseDataExample);
	}

	@Override
	public int saveWarBaseData(WarBaseData baseData) {
		baseData.setId(UUIDBuild.getUUID());
		return baseDataMapper.insert(baseData);
	}

	@Override
	public int updateWarBaseData(WarBaseData baseData) {
		return baseDataMapper.updateByPrimaryKey(baseData);
	}

	@Override
	public int deleteWarBaseDataById(String id) {
		return baseDataMapper.deleteByPrimaryKey(id);
	}


}
