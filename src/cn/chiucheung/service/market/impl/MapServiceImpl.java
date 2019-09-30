package cn.chiucheung.service.market.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.sales.projectinfo.SalProjectInfoMapper;
import cn.chiucheung.dao.mapper.system.map.SysMapLliMapper;
import cn.chiucheung.po.system.map.SysMapLli;
import cn.chiucheung.po.system.map.SysMapLliExample;
import cn.chiucheung.pojo.market.map.MapDataCustom;
import cn.chiucheung.pojo.market.map.ProjectInfoIndustryCount;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;
import cn.chiucheung.service.market.MapService;

@Service
public class MapServiceImpl implements MapService{
	
	@Autowired
	SalProjectInfoMapper projectInfoMapper;
	
	@Autowired
	SysMapLliMapper mapLliMapper;


	@Override
	public Map<String, Object> getMapData(String parent, BigDecimal[] chiaLli, String linesCoreName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if ("world".equals(parent)){
				List<MapDataCustom> list = projectInfoMapper.getMapDataForWorld();
				
				getChartsData(map, list, parent, chiaLli, linesCoreName);
			}else if ("china".equals(parent)){
				List<MapDataCustom> list = projectInfoMapper.getMapDataForChina();
				
				getChartsData(map, list, parent, chiaLli, linesCoreName);
			}else{
				List<MapDataCustom> list = projectInfoMapper.getMapDataForProvince(parent);
				
				getChartsData(map, list, parent, chiaLli, linesCoreName);
			}
			
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 生成echarts需要的数据
	 * @param map 回传的map
	 * @param list 地图显示的数据
	 * @param parent 地图经纬度查询的字段
	 * @param linesCoreName echarts lines中心点的名称
	 */
	private void getChartsData(Map<String, Object> map, List<MapDataCustom> list, String parent, BigDecimal[] chiaLli, String linesCoreName) {
		SysMapLliExample example = new SysMapLliExample();
		example.createCriteria().andParentEqualTo(parent);
		List<SysMapLli> mapLlis = mapLliMapper.selectByExample(example);
		Map<String, SysMapLli> mapLlis2 = new HashMap<String, SysMapLli>();
		for (SysMapLli mapLli : mapLlis) {
			mapLlis2.put(mapLli.getName(), mapLli);
		}
		
		
		MapDataCustom[] mapDataCustoms = new MapDataCustom[list.size()];
		JSONArray effectScatters = new JSONArray();
		JSONArray lines = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			MapDataCustom mapDataCustom = list.get(i);
			mapDataCustoms[i] = mapDataCustom;
			
			JSONObject effectScatter = new JSONObject();
			String name;
			if (parent.equals("world")){
				name = mapDataCustom.getEngName();
			}else{
				name = mapDataCustom.getName();
			}
			effectScatter.accumulate("name", name);
			effectScatter.accumulate("value", new BigDecimal[]{mapLlis2.get(name).getLongitude(),mapLlis2.get(name).getLatitude(),new BigDecimal(mapDataCustom.getValue())});
			effectScatters.add(effectScatter);
			
			if (("world".equals(parent) || "china".equals(parent))){
				JSONObject line = new JSONObject();
				line.accumulate("fromName", linesCoreName);
				line.accumulate("toName", name);
				BigDecimal[][] coords = {chiaLli,{mapLlis2.get(name).getLongitude(),mapLlis2.get(name).getLatitude()}};
				line.accumulate("coords", coords);
				lines.add(line);
			}
		}
		
		map.put("data", mapDataCustoms);//地图series(map)使用的数据
		
		map.put("effectScatters", effectScatters);//地图series(effectScatter)使用的数据
		
		if (StringUtils.isNotBlank(linesCoreName) && ("world".equals(parent) || "china".equals(parent))){
			map.put("lines", lines);//地图series(lines)使用的数据
		}
	}

	@Override
	public List<ProjectInfoIndustryCount> findProjectInfoIndustryCount(SalProjectInfoQueryVo projectInfoQueryVo) {
		return projectInfoMapper.findProjectInfoIndustryCount(projectInfoQueryVo);
	}

}
