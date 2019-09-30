package cn.chiucheung.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.system.dictionarie.SysDictionarieMapper;
import cn.chiucheung.po.system.dictionarie.SysDictionarie;
import cn.chiucheung.po.system.dictionarie.SysDictionarieExample;
import cn.chiucheung.service.system.DictionarieService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class DictionarieServiceImpl implements DictionarieService{
	
	@Autowired
	SysDictionarieMapper dictionarieMapper;

	@Override
	public List<SysDictionarie> findAllKeywordByDistinct() {
		List<SysDictionarie> list = dictionarieMapper.findAllKeywordByDistinct();
		//id为空，combobox加载的时候会有错误
		for (int i=0;i<list.size();i++){
			list.get(i).setId(i+"");
		}
		return list;
	}

	@Override
	public List<SysDictionarie> findAllDictionarieByKeyword(String keyword) {
		SysDictionarieExample dictionarieExample = new SysDictionarieExample();
		dictionarieExample.setOrderByClause("dictionarie_code");
		dictionarieExample.createCriteria().andKeywordEqualTo(keyword);
		return dictionarieMapper.selectByExample(dictionarieExample);
	}

	@Override
	public int saveSysDictionarie(SysDictionarie dictionarie) {
		dictionarie.setId(UUIDBuild.getUUID());
		return dictionarieMapper.insert(dictionarie);
	}

	@Override
	public int updateSysDictionarie(SysDictionarie dictionarie) {
		return dictionarieMapper.updateByPrimaryKey(dictionarie);
	}

	@Override
	public int deleteSysDictionarieById(String id) {
		return dictionarieMapper.deleteByPrimaryKey(id);
	}


}
