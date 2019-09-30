package cn.chiucheung.service.production.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.production.standard.ProProcessMapper;
import cn.chiucheung.dao.mapper.production.standard.ProTechnologyBasicDataMapper;
import cn.chiucheung.dao.mapper.production.standard.ProTechnologyWorkHoursBasicDataMapper;
import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.production.standard.ProTechnologyBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyBasicDataExample;
import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicDataExample;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyBasicDataCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyWorkHoursBasicDataCustom;
import cn.chiucheung.service.production.TechnologyWorkHoursBasicDataService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class TechnologyWorkHoursBasicDataServiceImpl implements TechnologyWorkHoursBasicDataService {
	
	@Autowired ProProcessMapper processMapper;
	
	@Autowired ProTechnologyBasicDataMapper technologyBasicDataMapper;
	
	@Autowired ProTechnologyWorkHoursBasicDataMapper technologyWorkHoursBasicDataMapper;
	
	@Override
	public int saveTechnology(ProTechnologyBasicData technologyBasicData) {
		technologyBasicData.setId(UUIDBuild.getUUID());
		return technologyBasicDataMapper.insert(technologyBasicData);
	}

	@Override
	public List<ProProcessTechnologyCustom> findAllProProcessTechnologyList(ProProcessQueryVo processQueryVo) {
		return processMapper.findAllProProcessTechnologyCustomList(processQueryVo);
	}
	
	@Override
	public List<ProProcessTechnologyCustom> findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId(String proProcessId) {
		List<ProProcessTechnologyCustom> processTechnologyCustoms = new ArrayList<ProProcessTechnologyCustom>();
		
		List<ProProcessTechnologyCustom> technologyBasicDatas = technologyBasicDataMapper.findAllProProcessTechnologyCustomList(proProcessId);
		
		List<ProProcessTechnologyCustom> technologyWorkHoursBasicDatas = technologyWorkHoursBasicDataMapper.findAllProProcessTechnologyCustomList(proProcessId);
		
		for (ProProcessTechnologyCustom processTechnologyCustom : technologyBasicDatas) {//按顺序添加
			processTechnologyCustoms.add(processTechnologyCustom);
			for (ProProcessTechnologyCustom processTechnologyCustom2 : technologyWorkHoursBasicDatas) {
				if (processTechnologyCustom.getId().equals(processTechnologyCustom2.getProTechnologyBasicDataId()))
				processTechnologyCustoms.add(processTechnologyCustom2);
			}
		}
		
		return processTechnologyCustoms;
	}

	@Override
	public ProProcessTechnologyCustom findTechnologyById(String id) {
		return technologyBasicDataMapper.findTechnologyById(id);
	}

	@Override
	public int updateTechnology(ProTechnologyBasicData technologyBasicData) {
		return technologyBasicDataMapper.updateByPrimaryKey(technologyBasicData);
	}

	@Override
	public int deleteTechnologyById(String id) {
		return technologyBasicDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProTechnologyBasicData> findTechnologyListByProProcessId(String id) {
		ProTechnologyBasicDataExample example = new ProTechnologyBasicDataExample();
		example.createCriteria().andProProcessIdEqualTo(id);
		return technologyBasicDataMapper.selectByExample(example);
	}

	@Override
	public int saveTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData) {
		technologyWorkHoursBasicData.setId(UUIDBuild.getUUID());
		return technologyWorkHoursBasicDataMapper.insert(technologyWorkHoursBasicData);
	}

	@Override
	public ProProcessTechnologyCustom findTechnologyWorkHoursById(String id) {
		return technologyWorkHoursBasicDataMapper.findTechnologyWorkHoursById(id);
	}

	@Override
	public int updateTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData) {
		return technologyWorkHoursBasicDataMapper.updateByPrimaryKey(technologyWorkHoursBasicData);
	}

	@Override
	public int deleteTechnologyWorkHoursById(String id) {
		return technologyWorkHoursBasicDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProTechnologyBasicDataCustom> findProcessTechnologyByProcessId(String processId, String calculationMethod) {
		List<ProTechnologyBasicDataCustom> technologyBasicDataCustoms = technologyBasicDataMapper.findProTechnologyBasicDataByProProcessId(processId);
		
		List<ProTechnologyWorkHoursBasicDataCustom> technologyWorkHoursBasicDataCustoms = technologyWorkHoursBasicDataMapper.findProTechnologyWorkHoursBasicDataByProProcessId(processId);
		
		
		Map<String, String> map = new HashMap<String, String>();//存放每段标识符对应的值
		if (StringUtils.isNotBlank(calculationMethod)){
			String[] technologyIdentifications = calculationMethod.split("&#10;")[1].split("[+|-|*|/|(|)]");
			String[] values = calculationMethod.split("<br>")[0].split("[+|-|*|/|(|)]");
			for(int i=0;i<technologyIdentifications.length;i++){
				if (StringUtils.isNotBlank(technologyIdentifications[i])){
					map.put(technologyIdentifications[i], values[i]);
				}
			}
		}
		
		
		for (ProTechnologyBasicDataCustom technologyBasicDataCustom : technologyBasicDataCustoms) {
			
			List<ProTechnologyWorkHoursBasicDataCustom> list2 = new ArrayList<ProTechnologyWorkHoursBasicDataCustom>();
			boolean b = false;
			for (ProTechnologyWorkHoursBasicDataCustom technologyWorkHoursBasicDataCustom : technologyWorkHoursBasicDataCustoms) {
				if (technologyBasicDataCustom.getId().equals(technologyWorkHoursBasicDataCustom.getProTechnologyBasicDataId())){
					list2.add(technologyWorkHoursBasicDataCustom);
				}
			}
			technologyBasicDataCustom.setTechnologyWorkHoursBasicDatas(list2);
		}
		
		if (StringUtils.isNotBlank(calculationMethod) && map != null && map.size() > 0){
			for (ProTechnologyBasicDataCustom technologyBasicDataCustom : technologyBasicDataCustoms) {
				String value = map.get(technologyBasicDataCustom.getTechnologyIdentification());//获取标识符
				technologyBasicDataCustom.setValue(value);
				boolean b = false;
				int j = 0;
				for (int i=0;i<technologyBasicDataCustom.getTechnologyWorkHoursBasicDatas().size();i++) {
					ProTechnologyWorkHoursBasicDataCustom technologyWorkHoursBasicDataCustom = technologyBasicDataCustom.getTechnologyWorkHoursBasicDatas().get(i);
					if ((technologyWorkHoursBasicDataCustom.getTechnologyTime()+"").equals(value) && !b){//表示找到了对应的值，则将该值设置为默认选中
						b = true;
						technologyWorkHoursBasicDataCustom.setSelected(true);
						break;
					}else{
						technologyWorkHoursBasicDataCustom.setSelected(false);
					}
					
					if (technologyWorkHoursBasicDataCustom.getTechnologyDescription().indexOf("手录") != -1){//记录手录的位置
						j = i;	
					}
				}
				if (!b){//从下拉选项中，没有找到对应的值，则是手录
					technologyBasicDataCustom.getTechnologyWorkHoursBasicDatas().get(j).setSelected(true);
				}
			}
		}
		
		return technologyBasicDataCustoms;
	}

}
