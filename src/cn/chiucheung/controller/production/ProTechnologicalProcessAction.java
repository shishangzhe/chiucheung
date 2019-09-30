package cn.chiucheung.controller.production;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.dao.mapper.production.standard.ProProcessMapper;
import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.production.standard.ProProcessExample;
import cn.chiucheung.po.production.standard.ProProcessExample.Criteria;


@Controller
@RequestMapping("/production/technologicalProcess")
public class ProTechnologicalProcessAction {
	
	@Autowired
	ProProcessMapper processMapper;
	
	@RequestMapping("index")
	public String index(){
		return "production/technologicalProcess1";
	}
	
	@RequestMapping("generateCharts")
	@ResponseBody
	public JSONObject generateCharts(String data,int quantity,int zd){
		JSONObject returnJsonObject = new JSONObject();//用于返回给页面的json数据
		
		JSONObject jsonObject = JSONObject.fromObject(data);
		
		String startKey = "";//存放工艺流程第一个开始的key
		String endKey = "";//存放工艺流程结束的key
		
		JSONArray nodeDataArray = jsonObject.getJSONArray("nodeDataArray");//获取所有的工序节点
		Map<String, HashMap<String, Double>> nodeDataMap = new HashMap<String, HashMap<String,Double>>();//存放所有工序对应的工时
		for (int i = 0; i < nodeDataArray.size(); i++) {//遍历所有的工序节点
			
			String category = nodeDataArray.getJSONObject(i).get("category").toString();//获取节点类型
			if ("Start".equals(category)){
				startKey = nodeDataArray.getJSONObject(i).getString("key");
			}else if ("End".equals(category)){
				endKey = nodeDataArray.getJSONObject(i).getString("key");
			}else{//出去节点中开始和结束的节点，因为这不属于工序，但前面存放了开始和结束标志的key
				HashMap<String, Double> map = new HashMap<String, Double>();
				map.put(nodeDataArray.getJSONObject(i).getString("text"), nodeDataArray.getJSONObject(i).getDouble("time"));
				nodeDataMap.put(nodeDataArray.getJSONObject(i).getString("key"), map);
			}
		}
		
		//System.out.println(startKey);
		
		JSONArray linkDataArray = jsonObject.getJSONArray("linkDataArray");//获取所有工序连接的节点
		List<String> firstKeys = new ArrayList<String>();//是否要考虑找到的删除，那样的话这个list的不止存key了，而是存整个JSONObject，然后JSONArray.remove(JSONObject)
		for (int i=0;i<linkDataArray.size();i++){
			if (linkDataArray.getJSONObject(i).getString("from").equals(startKey)){
				firstKeys.add(linkDataArray.getJSONObject(i).getString("to"));
			}
		}
		
		
		Map<String, List<String>> keys1 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的后面的所有key的集合
		Map<String, List<String>> keys2 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的前面的所有key的集合
		//遍历所有工序之间连接的节点，把每个工序下面包含的节点，和每个工序前面的节点，分别存到两个map里
		for (int i=0;i<linkDataArray.size();i++){
			String fromKey = linkDataArray.getJSONObject(i).getString("from");//上一节点
			String toKey = linkDataArray.getJSONObject(i).getString("to");//下一节点
			if (keys1.containsKey(fromKey)){
				keys1.get(fromKey).add(toKey);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(toKey);
				keys1.put(fromKey, list);
			}
			
			if (keys2.containsKey(toKey)){
				keys2.get(toKey).add(fromKey);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(fromKey);
				keys2.put(toKey, list);
			}
		}
		
		for (Entry<String, List<String>> entry : keys1.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		System.out.println("顺序------------倒序");
		for (Entry<String, List<String>> entry : keys2.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
		//存储所有工序的日期，初始化从哪天开始
		Date[] dates = new Date[nodeDataMap.size()];
		for (int i=0;i<nodeDataMap.size();i++){
			dates[i] = new Date(2018-1900, 0, 25, 0, 0, 0);
		}
		//System.out.println(dates[0].getTime());
		List<String> yAxis = new ArrayList<String>();//存储工序的名称
		List<String> keyList = new ArrayList<String>();//存在工序的key，是否考虑跟上面的dates[]结合起来
		List<Double> date = new ArrayList<Double>();//存储工序所需时间
		
		Map<String, Double> keyDate = new HashMap<String, Double>();//工序key对应的时间
		
		//给上面定义的集合添加好数据
		for (Entry<String, List<String>> entry : keys1.entrySet()) {
			if (!entry.getKey().equals(startKey)){
				HashMap<String, Double> hashMap = nodeDataMap.get(entry.getKey());
				for (Entry<String, Double> hashMapEntry : hashMap.entrySet()) {
					yAxis.add(hashMapEntry.getKey());
					keyList.add(entry.getKey());
					date.add(hashMapEntry.getValue());
					
					keyDate.put(entry.getKey(), hashMapEntry.getValue());
				}
			}
		}
		System.out.println(yAxis);
		System.out.println(keyList);
		System.out.println(date);
		
		
		
		
		
		
		long[][] data1 = new long[quantity][dates.length];
		long[][] data11 = new long[quantity][dates.length];
		Double[][] times = new Double[quantity][dates.length];//存储每个工序完成当天的剩余的工时，为了页面好计算，因为11/24，除不清，所以用这个方法计算的话，前台页面有误差
		for (int k=0;k<quantity;k++){
			//先给每个加上时间
			for (int i = 0; i < keyList.size(); i++) {
				Double d = keyDate.get(keyList.get(i));
				dates[i].setTime((long) (dates[i].getTime() + d*24/zd*3600*1000));
			}
			//List<String> startKeys = keys1.get(startKey);//获取到开始后面的所有节点
			
			ArrayList<String> startKeys = (ArrayList<String>) ((ArrayList<String>)keys1.get(startKey)).clone();
			
			
			
			List<String> nextKeys = new ArrayList<String>();//存放后面所有的节点
			while (startKeys.size() > 0){//由于每一次循环都是清空startKeys，在将nextKeys放入startsKeys，所以在没有下一节点的时候，整个流程就走完了
				nextKeys.clear();
				for (String string : startKeys) {//开始遍历
					List<String> list = keys1.get(string);//获取下一节点的集合
					for (String string2 : list) {//遍历获取每一个下一节点的key,然后找到的下一节点，跟上一节点作比较
						if (!string2.equals(endKey)){//确保不是结束的节点，如果是结束的节点则不做任何操作，但是如果工序只有一个节点，还得设置
							int pre = 0;//存放startKey在dates、times的位置
							int next = 0;//存放nextKey在dates、times的位置
							//Double d;
							for (int i = 0; i < keyList.size(); i++) {//获取工序，在整个工序的集合中，是哪个，以便后面的dates和times与其一一对应
								if (keyList.get(i).equals(string)){
									pre = i;
								}
								if (keyList.get(i).equals(string2)){
									next = i;
								}
							}
							
							//当前工序的结束时间dates[next].getTime()减去当前工序所需时间，就得到当前工序开始的时间，去跟当前工序的前一工序进行比较，如果大于前一工序，则不需要改变，如果小于前一工序，则需要在前一工序加上当前工序所需时间
							boolean flag = (dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000) >= dates[pre].getTime();
							
							/*dates[next].setTime(
								(long) ((dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000)
									>=
								dates[pre].getTime()
									?
								dates[next].getTime()
									:
								dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000)
							);*/
							if (keys1.get(startKey).contains(string)){//表示开始的第一道工序
								if (k == 0){//如何是第一个工咭，表示前面没有任何工咭，则直接从0开始，不需要考虑前面的，直接用当前的工序所需时间来计算
									times[k][pre] = keyDate.get(string)%zd;
								}else{//不是第一个工咭，则用当前的工序所需时间加上该工序上一工咭该工序时间%zd后的时间来计算
									times[k][pre] = (keyDate.get(string)+times[k-1][pre])%zd;
								}
							}
							
							if (!flag){//当前工序的开始时间小于前一工序的结束时间，则该工序需要从前一工序+改工序的时间
								dates[next].setTime((long) (dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000));
								
								times[k][next] = (keyDate.get(string2)+times[k][pre])%zd;
							}else{//当前工序的开始时间大于前一工序的结束时间,则直接取当前工序的时间
								//dates[next].setTime(dates[next].getTime());
								if (times[k][next] == null){//如果不为null，说明他前面有多个工序，并且和一个工序比较过了，有值了，就不需要设置了
															//如果为null，说明该工序的开始时间是紧跟着上一工咭的该工序，则需要该工序所需时间加上上一工咭该工序所需时间在%zd
									times[k][next] = (keyDate.get(string2)+times[k-1][next])%zd;
								}
							}
							nextKeys.add(string2);
						}else{//当只有一个工序节点的时候
							if (keyList.size() == 1){
								times[k][0] = keyDate.get(string)%zd;
							}
						}
					}
				}
				startKeys.clear();
				startKeys.addAll(nextKeys);
			}
			
			
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < dates.length; i++) {
				System.out.println(dateFormat.format(dates[i].getTime()));
				data1[k][i] = dates[i].getTime();
			}
			System.out.println("----------");
			
			
			for (int i = 0; i < keyList.size(); i++) {
				Date date1111 = new Date((long) (dates[i].getTime()-keyDate.get(keyList.get(i))*24/zd*3600*1000));
				System.out.println(dateFormat.format(date1111));
				data11[k][i] = date1111.getTime();
			}
		}
		
		returnJsonObject.accumulate("yAxis", yAxis.toArray());
		returnJsonObject.accumulate("data1", data1);
		returnJsonObject.accumulate("data11", data11);
		returnJsonObject.accumulate("times", times);
		
		/*Map<String,Double> nullDate = new HashMap<String, Double>();
		//在根据排序，每个工序添加时间
		for (Entry<String, List<String>> entry : keys1.entrySet()) {
			List<String> list = entry.getValue();
			for (String string : list) {
				if (!entry.getKey().equals(startKey)){
					if (!string.equals(endKey)){
						//获取本身的时间
						Double time = 0.0;
						for (int i = 0; i < keyList.size(); i++) {
							if(keyList.get(i).equals(string)){
								time = date.get(i);
							}
						}
						//类似js的，先减去需要的时间，就是开始的时间，然后去判断开始的时间是不是大于前一工序流程的时间，大于则无语更改，小于则取前一工序流程的时间开始
						keyDate.put(string, (keyDate.get(string)-time) > keyDate.get(entry.getKey()) ? keyDate.get(string) : keyDate.get(entry.getKey()) + time);
						nullDate.put(string, keyDate.get(string)-time);
					}
				}else{
					nullDate.put(string, 0.0);
				}
			}
		}
		
		for (Entry<String, Double> entry : keyDate.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("---------");
		for (Entry<String, Double> entry : nullDate.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
		for (int i = 0; i < keyList.size(); i++) {
			long j = (long) (keyDate.get(keyList.get(i))*3*3600*1000);
			System.out.println(j);
			dates[i].setTime(dates[i].getTime() + j);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dateFormat.format(dates[i].getTime()));
		}
		
		
		
		
		returnJsonObject.accumulate("yAxis", yAxis.toArray());
		
		long[] times1 = new long[dates.length];
		for (int i = 0; i < dates.length; i++) {
			times1[i] = dates[i].getTime();
		}
		
		returnJsonObject.accumulate("data1", times1);
		System.out.println("----------");
		long[] times2=  new long[dates.length];
		for (int i = 0; i < keyList.size(); i++) {
			times2[i] = (long) (dates[i].getTime() - date.get(i)*3*3600*1000);
			System.out.println(dateFormat.format(new Date(times2[i])));
		}
		
		
		returnJsonObject.accumulate("data11", times2);
		
		System.out.println(returnJsonObject.toString());*/
		/*for (Entry<String, List<String>> entry : keys1.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		System.out.println("顺序------------倒序");
		for (Entry<String, List<String>> entry : keys2.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}*/
		/*while (b) {
			nextKeys.clear();
			for (String key : firstKeys) {//遍历当前节点的key
				System.out.print(key);
				System.out.print("-->");
				for (int j=0;j<linkDataArray.size();j++){
					if (linkDataArray.getJSONObject(j).getString("from").equals(key)){
						if (!linkDataArray.getJSONObject(j).getString("to").equals(endKey)){//是否是最后一个节点
							if (!nextKeys.contains(linkDataArray.getJSONObject(j).getString("to"))){
								nextKeys.add(linkDataArray.getJSONObject(j).getString("to"));
							}
							if (!keys.containsKey(linkDataArray.getJSONObject(j).getString("to"))){
								List<String> list = new ArrayList<String>();
								list.add(key);
								keys.put(linkDataArray.getJSONObject(j).getString("to"), list);
							}else{
								keys.get(linkDataArray.getJSONObject(j).getString("to")).add(key);
							}
							System.out.print(linkDataArray.getJSONObject(j).getString("to"));
						}else{
							b =false;
						}
					}
				}
				System.out.println();
			}
			
			firstKeys.clear();
			firstKeys.addAll(nextKeys);
			if (nextKeys.size() <=0){
				b=false;
			}
		}*/
		
		return returnJsonObject;
	}
	
	/*
	 * 以下方法开始不经过 service，直接调用dao
	 */
	
	
	@RequestMapping("findAllDistinctProcess")
	@ResponseBody
	public List<ProProcess> findAllDistinctProcess(){
		return processMapper.findAllProcessByDistinct();
	}
	
	@RequestMapping("findAllProcessByProcessName")
	@ResponseBody
	public List<ProProcess> findAllProcessByProcessName(String processName){
		if (StringUtils.isNotBlank(processName)){
			ProProcessExample example = new ProProcessExample();
			Criteria criteria = example.createCriteria();
			criteria.andProcessNameEqualTo(processName);
			return processMapper.selectByExample(example);
		}else{
			return new ArrayList<ProProcess>();
		}
	}
	
	@RequestMapping("generateCharts1")
	@ResponseBody
	public JSONObject generateCharts1(String data,int quantity,int zd){
		JSONObject returnJsonObject = new JSONObject();//用于返回给页面的json数据
		
		try{
			JSONObject jsonObject = JSONObject.fromObject(data);
			
			String startKey = "";//存放工艺流程第一个开始的key
			String endKey = "";//存放工艺流程结束的key
			
			JSONArray nodeDataArray = jsonObject.getJSONArray("nodeDataArray");//获取所有的工序节点
			Map<String, HashMap<String, Double>> nodeDataMap = new HashMap<String, HashMap<String, Double>>();//存放所有工序对应的工时
			for (int i = 0; i < nodeDataArray.size(); i++) {//遍历所有的工序节点
				
				String category = nodeDataArray.getJSONObject(i).get("category").toString();//获取节点类型
				if ("Start".equals(category)){
					if ("".equals(startKey)){
						startKey = nodeDataArray.getJSONObject(i).getString("key");
					}else{
						throw new RuntimeException("只能有一个开始节点");
					}
				}else if ("End".equals(category)){
					if ("".equals(endKey)){
						endKey = nodeDataArray.getJSONObject(i).getString("key");
					}else{
						throw new RuntimeException("只能有一个结束节点");
					}
				}else{//出去节点中开始和结束的节点，因为这不属于工序，但前面存放了开始和结束标志的key
					if (!StringUtils.isNotBlank(nodeDataArray.getJSONObject(i).getString("processId"))){
						throw new RuntimeException("有节点没有选择工序");
					}
					
					if (!StringUtils.isNotBlank(nodeDataArray.getJSONObject(i).getString("time"))){
						throw new RuntimeException(nodeDataArray.getJSONObject(i).getString("processName")+"---"+nodeDataArray.getJSONObject(i).getString("processCategory")+"的节点没有填工时");
					}
					
					try{
						Double.parseDouble(nodeDataArray.getJSONObject(i).getString("time"));
					}catch (NumberFormatException e){
						throw new RuntimeException(nodeDataArray.getJSONObject(i).getString("processName")+"---"+nodeDataArray.getJSONObject(i).getString("processCategory")+"的节点的工时不是数字");
					}
					
					HashMap<String, Double> map = new HashMap<String, Double>();
					map.put(nodeDataArray.getJSONObject(i).getString("processId"), nodeDataArray.getJSONObject(i).getDouble("time"));
					nodeDataMap.put(nodeDataArray.getJSONObject(i).getString("key"), map);
					
				}
			}
			
			if (!StringUtils.isNotBlank(startKey)){
				throw new RuntimeException("没有开始节点");
			}
			
			if (!StringUtils.isNotBlank(endKey)){
				throw new RuntimeException("没有结束节点");
			}
			
			//System.out.println(startKey);
			
			JSONArray linkDataArray = jsonObject.getJSONArray("linkDataArray");//获取所有工序连接的节点
			List<String> firstKeys = new ArrayList<String>();//是否要考虑找到的删除，那样的话这个list的不止存key了，而是存整个JSONObject，然后JSONArray.remove(JSONObject)
			for (int i=0;i<linkDataArray.size();i++){
				if (linkDataArray.getJSONObject(i).getString("from").equals(startKey)){
					firstKeys.add(linkDataArray.getJSONObject(i).getString("to"));
				}
			}
			
			
			Map<String, List<String>> keys1 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的后面的所有key的集合
			Map<String, List<String>> keys2 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的前面的所有key的集合
			//遍历所有工序之间连接的节点，把每个工序下面包含的节点，和每个工序前面的节点，分别存到两个map里
			for (int i=0;i<linkDataArray.size();i++){
				String fromKey = linkDataArray.getJSONObject(i).getString("from");//上一节点
				String toKey = linkDataArray.getJSONObject(i).getString("to");//下一节点
				if (keys1.containsKey(fromKey)){
					keys1.get(fromKey).add(toKey);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(toKey);
					keys1.put(fromKey, list);
				}
				
				if (keys2.containsKey(toKey)){
					keys2.get(toKey).add(fromKey);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(fromKey);
					keys2.put(toKey, list);
				}
			}
			
			validateData(nodeDataArray, keys1, keys2);
			
			for (Entry<String, List<String>> entry : keys1.entrySet()) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			System.out.println("顺序------------倒序");
			for (Entry<String, List<String>> entry : keys2.entrySet()) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			
			
			//存储所有工序的日期，初始化从哪天开始
			Date[] dates = new Date[nodeDataMap.size()];
			for (int i=0;i<nodeDataMap.size();i++){
				dates[i] = new Date(2018-1900, 2, 1, 0, 0, 0);
			}
			//System.out.println(dates[0].getTime());
			List<String> yAxis = new ArrayList<String>();//存储工序的名称
			List<String> keyList = new ArrayList<String>();//存在工序的key，是否考虑跟上面的dates[]结合起来
			List<Double> date = new ArrayList<Double>();//存储工序所需时间
			
			Map<String, Double> keyDate = new HashMap<String, Double>();//工序key对应的时间
			
			//给上面定义的集合添加好数据
			for (Entry<String, List<String>> entry : keys1.entrySet()) {
				if (!entry.getKey().equals(startKey)){
					HashMap<String, Double> hashMap = nodeDataMap.get(entry.getKey());
					for (Entry<String, Double> hashMapEntry : hashMap.entrySet()) {
						yAxis.add(hashMapEntry.getKey());
						keyList.add(entry.getKey());
						date.add(hashMapEntry.getValue());
						
						keyDate.put(entry.getKey(), hashMapEntry.getValue());
					}
				}
			}
			System.out.println(yAxis);
			System.out.println(keyList);
			System.out.println(date);
			
			
			
			
			
			
			long[][] data1 = new long[quantity][dates.length];
			long[][] data11 = new long[quantity][dates.length];//空闲
			Double[][] times = new Double[quantity][dates.length];//存储每个工序完成当天的剩余的工时，为了页面好计算，因为11/24，除不清，所以用这个方法计算的话，前台页面有误差
			for (int k=0;k<quantity;k++){
				//先给每个加上时间
				for (int i = 0; i < keyList.size(); i++) {
					Double d = keyDate.get(keyList.get(i));
					dates[i].setTime((long) (dates[i].getTime() + d*24/zd*3600*1000));
				}
				//List<String> startKeys = keys1.get(startKey);//获取到开始后面的所有节点
				
				ArrayList<String> startKeys = (ArrayList<String>) ((ArrayList<String>)keys1.get(startKey)).clone();
				
				
				
				List<String> nextKeys = new ArrayList<String>();//存放后面所有的节点
				while (startKeys.size() > 0){//由于每一次循环都是清空startKeys，在将nextKeys放入startsKeys，所以在没有下一节点的时候，整个流程就走完了
					nextKeys.clear();
					for (String string : startKeys) {//开始遍历
						List<String> list = keys1.get(string);//获取下一节点的集合
						for (String string2 : list) {//遍历获取每一个下一节点的key,然后找到的下一节点，跟上一节点作比较
							if (!string2.equals(endKey)){//确保不是结束的节点，如果是结束的节点则不做任何操作，但是如果工序只有一个节点，还得设置
								int pre = 0;//存放startKey在dates、times的位置
								int next = 0;//存放nextKey在dates、times的位置
								//Double d;
								for (int i = 0; i < keyList.size(); i++) {//获取工序，在整个工序的集合中，是哪个，以便后面的dates和times与其一一对应
									if (keyList.get(i).equals(string)){
										pre = i;
									}
									if (keyList.get(i).equals(string2)){
										next = i;
									}
								}
								
								//当前工序的结束时间dates[next].getTime()减去当前工序所需时间，就得到当前工序开始的时间，去跟当前工序的前一工序进行比较，如果大于前一工序，则不需要改变，如果小于前一工序，则需要在前一工序加上当前工序所需时间
								boolean flag = (dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000) >= dates[pre].getTime();
								
								/*dates[next].setTime(
									(long) ((dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000)
										>=
									dates[pre].getTime()
										?
									dates[next].getTime()
										:
									dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000)
								);*/
								if (keys1.get(startKey).contains(string)){//表示开始的第一道工序
									if (k == 0){//如何是第一个工咭，表示前面没有任何工咭，则直接从0开始，不需要考虑前面的，直接用当前的工序所需时间来计算
										times[k][pre] = keyDate.get(string)%zd;
									}else{//不是第一个工咭，则用当前的工序所需时间加上该工序上一工咭该工序时间%zd后的时间来计算
										times[k][pre] = (keyDate.get(string)+times[k-1][pre])%zd;
									}
								}
								
								if (!flag){//当前工序的开始时间小于前一工序的结束时间，则该工序需要从前一工序+改工序的时间
									dates[next].setTime((long) (dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000));
									
									times[k][next] = (keyDate.get(string2)+times[k][pre])%zd;
								}else{//当前工序的开始时间大于前一工序的结束时间,则直接取当前工序的时间
									//dates[next].setTime(dates[next].getTime());
									if (times[k][next] == null){//如果不为null，说明他前面有多个工序，并且和一个工序比较过了，有值了，就不需要设置了
																//如果为null，说明该工序的开始时间是紧跟着上一工咭的该工序，则需要该工序所需时间加上上一工咭该工序所需时间在%zd
										times[k][next] = (keyDate.get(string2)+times[k-1][next])%zd;
									}
								}
								nextKeys.add(string2);
							}else{//当只有一个工序节点的时候
								if (keyList.size() == 1){
									times[k][0] = keyDate.get(string)%zd;
								}
							}
						}
					}
					startKeys.clear();
					startKeys.addAll(nextKeys);
				}
				
				
				
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (int i = 0; i < dates.length; i++) {
					System.out.println(dateFormat.format(dates[i].getTime()));
					data1[k][i] = dates[i].getTime();
				}
				System.out.println("----------");
				
				
				for (int i = 0; i < keyList.size(); i++) {
					Date date1111 = new Date((long) (dates[i].getTime()-keyDate.get(keyList.get(i))*24/zd*3600*1000));
					System.out.println(dateFormat.format(date1111));
					data11[k][i] = date1111.getTime();
				}
			}
			
			ProProcessExample processExample = new ProProcessExample();
			processExample.setOrderByClause("process_name");
			List<ProProcess> list = processMapper.selectByExample(processExample);
			
			List<String> returnYAxis = new ArrayList<String>();
			
			List<List<List<Long>>> returnData1 = new ArrayList<List<List<Long>>>();
			List<List<List<Long>>> returnData11 = new ArrayList<List<List<Long>>>();
			List<List<List<Double>>> returnTimes = new ArrayList<List<List<Double>>>();
			for (int i=0; i<quantity; i++) {
				
				List<List<Long>>  list1 = new ArrayList<List<Long>>();
				List<List<Long>>  list11 = new ArrayList<List<Long>>();
				List<List<Double>>  times1 = new ArrayList<List<Double>>();
				for (int j=0;j<list.size();j++){
					if (i == 0){
						returnYAxis.add(list.get(j).getProcessName()+":"+list.get(j).getProcessCategory());
					}
					
					List<Long> list2 = new ArrayList<Long>();
					
					list2.add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
					list1.add(list2);
					
					
					List<Long> list22 = new ArrayList<Long>();
					
					list22.add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
					list11.add(list22);
					
					
					List<Double> times2 = new ArrayList<Double>();
					
					times2.add(0d);
					times1.add(times2);
				}
				returnData1.add(list1);
				returnData11.add(list11);
				returnTimes.add(times1);
			}
			
			for (int i=0; i<list.size(); i++) {
				for (int j=0; j<yAxis.size(); j++){
					if (list.get(i).getId().equals(yAxis.get(j))){
						for (int k=0; k<quantity;k++){
							returnData1.get(k).get(i).add(data1[k][j]);
							returnData11.get(k).get(i).add(data11[k][j]);
							returnTimes.get(k).get(i).add(times[k][j]);
						}
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < returnData11.size(); i++) {
				for (int j = 0; j < returnData11.get(i).size(); j++) {
					if (max < returnData11.get(i).get(j).size()){
						max = returnData11.get(i).get(j).size();
					}
				}
			}
			
			for (int i = 0; i < returnData11.size(); i++) {
				for (int j = 0; j < returnData11.get(i).size(); j++) {
					for (int k = returnData11.get(i).get(j).size(); k < max; k++) {
						returnData1.get(i).get(j).add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
						returnData11.get(i).get(j).add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
						returnTimes.get(i).get(j).add(0d);
					}
				}
			}
			
			
			returnJsonObject.accumulate("success", true);
			/*returnJsonObject.accumulate("yAxis", yAxis.toArray());
			returnJsonObject.accumulate("data1", data1);
			returnJsonObject.accumulate("data11", data11);
			returnJsonObject.accumulate("times", times);*/
			returnJsonObject.accumulate("yAxis", returnYAxis.toArray());
			returnJsonObject.accumulate("data1", returnData1);
			returnJsonObject.accumulate("data11", returnData11);
			returnJsonObject.accumulate("times", returnTimes);
		}catch (Exception e){
			returnJsonObject.accumulate("success", false);
			returnJsonObject.accumulate("errorMsg", e.getMessage());
		}
		
		return returnJsonObject;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("generateCharts2")
	@ResponseBody
	public JSONObject generateCharts2(String data,int quantity,int zd){
		JSONObject returnJsonObject = new JSONObject();//用于返回给页面的json数据
		
		try{
			JSONObject jsonObject = JSONObject.fromObject(data);
			
			String startKey = "";//存放工艺流程第一个开始的key
			String endKey = "";//存放工艺流程结束的key
			
			JSONArray nodeDataArray = jsonObject.getJSONArray("nodeDataArray");//获取所有的工序节点
			Map<String, HashMap<String, Double>> nodeDataMap = new HashMap<String, HashMap<String, Double>>();//存放所有工序对应的工时
			for (int i = 0; i < nodeDataArray.size(); i++) {//遍历所有的工序节点
				
				String category = nodeDataArray.getJSONObject(i).get("category").toString();//获取节点类型
				if ("Start".equals(category)){
					if ("".equals(startKey)){
						startKey = nodeDataArray.getJSONObject(i).getString("key");
					}else{
						throw new RuntimeException("只能有一个开始节点");
					}
				}else if ("End".equals(category)){
					if ("".equals(endKey)){
						endKey = nodeDataArray.getJSONObject(i).getString("key");
					}else{
						throw new RuntimeException("只能有一个结束节点");
					}
				}else{//出去节点中开始和结束的节点，因为这不属于工序，但前面存放了开始和结束标志的key
					if (!StringUtils.isNotBlank(nodeDataArray.getJSONObject(i).getString("processId"))){
						throw new RuntimeException("有节点没有选择工序");
					}
					
					if (!StringUtils.isNotBlank(nodeDataArray.getJSONObject(i).getString("time"))){
						throw new RuntimeException(nodeDataArray.getJSONObject(i).getString("processName")+"---"+nodeDataArray.getJSONObject(i).getString("processCategory")+"的节点没有填工时");
					}
					
					try{
						Double.parseDouble(nodeDataArray.getJSONObject(i).getString("time"));
					}catch (NumberFormatException e){
						throw new RuntimeException(nodeDataArray.getJSONObject(i).getString("processName")+"---"+nodeDataArray.getJSONObject(i).getString("processCategory")+"的节点的工时不是数字");
					}
					
					HashMap<String, Double> map = new HashMap<String, Double>();
					map.put(nodeDataArray.getJSONObject(i).getString("processId"), nodeDataArray.getJSONObject(i).getDouble("time"));
					nodeDataMap.put(nodeDataArray.getJSONObject(i).getString("key"), map);
					
				}
			}
			
			if (!StringUtils.isNotBlank(startKey)){
				throw new RuntimeException("没有开始节点");
			}
			
			if (!StringUtils.isNotBlank(endKey)){
				throw new RuntimeException("没有结束节点");
			}
			
			//System.out.println(startKey);
			
			JSONArray linkDataArray = jsonObject.getJSONArray("linkDataArray");//获取所有工序连接的节点
			List<String> firstKeys = new ArrayList<String>();//是否要考虑找到的删除，那样的话这个list的不止存key了，而是存整个JSONObject，然后JSONArray.remove(JSONObject)
			for (int i=0;i<linkDataArray.size();i++){
				if (linkDataArray.getJSONObject(i).getString("from").equals(startKey)){
					firstKeys.add(linkDataArray.getJSONObject(i).getString("to"));
				}
			}
			
			
			Map<String, List<String>> keys1 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的后面的所有key的集合
			Map<String, List<String>> keys2 = new LinkedHashMap<String, List<String>>();//Map<String, List<String>> String是当前key，List<String>则是当前key的前面的所有key的集合
			//遍历所有工序之间连接的节点，把每个工序下面包含的节点，和每个工序前面的节点，分别存到两个map里
			for (int i=0;i<linkDataArray.size();i++){
				String fromKey = linkDataArray.getJSONObject(i).getString("from");//上一节点
				String toKey = linkDataArray.getJSONObject(i).getString("to");//下一节点
				if (keys1.containsKey(fromKey)){
					keys1.get(fromKey).add(toKey);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(toKey);
					keys1.put(fromKey, list);
				}
				
				if (keys2.containsKey(toKey)){
					keys2.get(toKey).add(fromKey);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(fromKey);
					keys2.put(toKey, list);
				}
			}
			
			validateData(nodeDataArray, keys1, keys2);
			
			for (Entry<String, List<String>> entry : keys1.entrySet()) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			System.out.println("顺序------------倒序");
			for (Entry<String, List<String>> entry : keys2.entrySet()) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			
			
			//存储所有工序的日期，初始化从哪天开始
			Date[] dates = new Date[nodeDataMap.size()];
			for (int i=0;i<nodeDataMap.size();i++){
				dates[i] = new Date(2018-1900, 2, 1, 0, 0, 0);
			}
			//System.out.println(dates[0].getTime());
			List<String> yAxis = new ArrayList<String>();//存储工序的名称
			List<String> keyList = new ArrayList<String>();//存在工序的key，是否考虑跟上面的dates[]结合起来
			List<Double> date = new ArrayList<Double>();//存储工序所需时间
			
			Map<String, Double> keyDate = new HashMap<String, Double>();//工序key对应的时间
			
			//给上面定义的集合添加好数据
			for (Entry<String, List<String>> entry : keys1.entrySet()) {
				if (!entry.getKey().equals(startKey)){
					HashMap<String, Double> hashMap = nodeDataMap.get(entry.getKey());
					for (Entry<String, Double> hashMapEntry : hashMap.entrySet()) {
						yAxis.add(hashMapEntry.getKey());
						keyList.add(entry.getKey());
						date.add(hashMapEntry.getValue());
						
						keyDate.put(entry.getKey(), hashMapEntry.getValue());
					}
				}
			}
			System.out.println(yAxis);
			System.out.println(keyList);
			System.out.println(date);
			
			
			
			
			
			
			long[][] data1 = new long[quantity][dates.length];
			long[][] data11 = new long[quantity][dates.length];//空闲
			Double[][] times = new Double[quantity][dates.length];//存储每个工序完成当天的剩余的工时，为了页面好计算，因为11/24，除不清，所以用这个方法计算的话，前台页面有误差
			for (int k=0;k<quantity;k++){
				//先给每个加上时间
				for (int i = 0; i < keyList.size(); i++) {
					Double d = keyDate.get(keyList.get(i));
					dates[i].setTime((long) (dates[i].getTime() + d*24/zd*3600*1000));
				}
				//List<String> startKeys = keys1.get(startKey);//获取到开始后面的所有节点
				
				ArrayList<String> startKeys = (ArrayList<String>) ((ArrayList<String>)keys1.get(startKey)).clone();
				
				
				
				List<String> nextKeys = new ArrayList<String>();//存放后面所有的节点
				while (startKeys.size() > 0){//由于每一次循环都是清空startKeys，在将nextKeys放入startsKeys，所以在没有下一节点的时候，整个流程就走完了
					nextKeys.clear();
					for (String string : startKeys) {//开始遍历
						List<String> list = keys1.get(string);//获取下一节点的集合
						for (String string2 : list) {//遍历获取每一个下一节点的key,然后找到的下一节点，跟上一节点作比较
							if (!string2.equals(endKey)){//确保不是结束的节点，如果是结束的节点则不做任何操作，但是如果工序只有一个节点，还得设置
								int pre = 0;//存放startKey在dates、times的位置
								int next = 0;//存放nextKey在dates、times的位置
								//Double d;
								for (int i = 0; i < keyList.size(); i++) {//获取工序，在整个工序的集合中，是哪个，以便后面的dates和times与其一一对应
									if (keyList.get(i).equals(string)){
										pre = i;
									}
									if (keyList.get(i).equals(string2)){
										next = i;
									}
								}
								
								//当前工序的结束时间dates[next].getTime()减去当前工序所需时间，就得到当前工序开始的时间，去跟当前工序的前一工序进行比较，如果大于前一工序，则不需要改变，如果小于前一工序，则需要在前一工序加上当前工序所需时间
								boolean flag = (dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000) >= dates[pre].getTime();
								
								/*dates[next].setTime(
									(long) ((dates[next].getTime()-keyDate.get(string2)*24/zd*3600*1000)
										>=
									dates[pre].getTime()
										?
									dates[next].getTime()
										:
									dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000)
								);*/
								if (keys1.get(startKey).contains(string)){//表示开始的第一道工序
									if (k == 0){//如何是第一个工咭，表示前面没有任何工咭，则直接从0开始，不需要考虑前面的，直接用当前的工序所需时间来计算
										times[k][pre] = keyDate.get(string)%zd;
									}else{//不是第一个工咭，则用当前的工序所需时间加上该工序上一工咭该工序时间%zd后的时间来计算
										times[k][pre] = (keyDate.get(string)+times[k-1][pre])%zd;
									}
								}
								
								if (!flag){//当前工序的开始时间小于前一工序的结束时间，则该工序需要从前一工序+改工序的时间
									dates[next].setTime((long) (dates[pre].getTime() + keyDate.get(string2)*24/zd*3600*1000));
									
									times[k][next] = (keyDate.get(string2)+times[k][pre])%zd;
								}else{//当前工序的开始时间大于前一工序的结束时间,则直接取当前工序的时间
									//dates[next].setTime(dates[next].getTime());
									if (times[k][next] == null){//如果不为null，说明他前面有多个工序，并且和一个工序比较过了，有值了，就不需要设置了
																//如果为null，说明该工序的开始时间是紧跟着上一工咭的该工序，则需要该工序所需时间加上上一工咭该工序所需时间在%zd
										times[k][next] = (keyDate.get(string2)+times[k-1][next])%zd;
									}
								}
								nextKeys.add(string2);
							}else{//当只有一个工序节点的时候
								if (keyList.size() == 1){
									times[k][0] = keyDate.get(string)%zd;
								}
							}
						}
					}
					startKeys.clear();
					startKeys.addAll(nextKeys);
				}
				
				
				
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (int i = 0; i < dates.length; i++) {
					System.out.println(dateFormat.format(dates[i].getTime()));
					data1[k][i] = dates[i].getTime();
				}
				System.out.println("----------");
				
				
				for (int i = 0; i < keyList.size(); i++) {
					Date date1111 = new Date((long) (dates[i].getTime()-keyDate.get(keyList.get(i))*24/zd*3600*1000));
					System.out.println(dateFormat.format(date1111));
					data11[k][i] = date1111.getTime();
				}
			}
			
			ProProcessExample processExample = new ProProcessExample();
			processExample.setOrderByClause("process_name");
			List<ProProcess> list = processMapper.selectByExample(processExample);
			
			List<String> returnYAxis = new ArrayList<String>();
			
			List<List<List<Long>>> returnData1 = new ArrayList<List<List<Long>>>();
			List<List<List<Long>>> returnData11 = new ArrayList<List<List<Long>>>();//空闲时间
			List<List<List<Double>>> returnTimes = new ArrayList<List<List<Double>>>();
			for (int i=0; i<quantity; i++) {
				
				List<List<Long>>  list1 = new ArrayList<List<Long>>();
				List<List<Long>>  list11 = new ArrayList<List<Long>>();
				List<List<Double>>  times1 = new ArrayList<List<Double>>();
				for (int j=0;j<list.size();j++){
					if (i == 0){
						returnYAxis.add(list.get(j).getProcessName()+":"+list.get(j).getProcessCategory());
					}
					
					List<Long> list2 = new ArrayList<Long>();
					
					list2.add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
					list1.add(list2);
					
					
					List<Long> list22 = new ArrayList<Long>();
					
					list22.add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
					list11.add(list22);
					
					
					List<Double> times2 = new ArrayList<Double>();
					
					times2.add(0d);
					times1.add(times2);
				}
				returnData1.add(list1);
				returnData11.add(list11);
				returnTimes.add(times1);
			}
			
			for (int i=0; i<list.size(); i++) {
				for (int j=0; j<yAxis.size(); j++){
					if (list.get(i).getId().equals(yAxis.get(j))){
						for (int k=0; k<quantity;k++){
							returnData1.get(k).get(i).add(data1[k][j]);
							returnData11.get(k).get(i).add(data11[k][j]);
							returnTimes.get(k).get(i).add(times[k][j]);
						}
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < returnData11.size(); i++) {
				for (int j = 0; j < returnData11.get(i).size(); j++) {
					if (max < returnData11.get(i).get(j).size()){
						max = returnData11.get(i).get(j).size();
					}
				}
			}
			
			for (int i = 0; i < returnData11.size(); i++) {
				for (int j = 0; j < returnData11.get(i).size(); j++) {
					for (int k = returnData11.get(i).get(j).size(); k < max; k++) {
						returnData1.get(i).get(j).add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
						returnData11.get(i).get(j).add(new Date(2018-1900, 2, 1, 0, 0, 0).getTime());
						returnTimes.get(i).get(j).add(0d);
					}
				}
			}
			
			
			returnJsonObject.accumulate("success", true);
			/*returnJsonObject.accumulate("yAxis", yAxis.toArray());
			returnJsonObject.accumulate("data1", data1);
			returnJsonObject.accumulate("data11", data11);
			returnJsonObject.accumulate("times", times);*/
			returnJsonObject.accumulate("yAxis", returnYAxis.toArray());
			returnJsonObject.accumulate("data1", returnData1);
			returnJsonObject.accumulate("data11", returnData11);
			returnJsonObject.accumulate("times", returnTimes);
		}catch (Exception e){
			returnJsonObject.accumulate("success", false);
			returnJsonObject.accumulate("errorMsg", e.getMessage());
		}
		
		return returnJsonObject;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param nodeDataArray
	 * @param keys1 key后面的
	 * @param keys2 key前面的
	 * @return
	 */
	public void validateData(JSONArray nodeDataArray, Map<String, List<String>> keys1, Map<String, List<String>> keys2){
		if (nodeDataArray.size() < 3){
			throw new RuntimeException("没有工序节点");
		}
		for (int i = 0; i < nodeDataArray.size(); i++) {
			JSONObject jsonObject = nodeDataArray.getJSONObject(i);
			String category = jsonObject.getString("category");//获取节点类型
			String key = jsonObject.getString("key");//获取节点的key
			if ("Start".equals(category)){
				if (!keys1.containsKey(key)){
					throw new RuntimeException("开始节点后面没有连线");
				}
			}else if ("End".equals(category)){
				if (!keys2.containsKey(key)){
					throw new RuntimeException("结束节点前面没有连线");
				}
			}else{//出去节点中开始和结束的节点，因为这不属于工序，但前面存放了开始和结束标志的key
				if (!keys1.containsKey(key)){
					throw new RuntimeException(jsonObject.getString("processName")+"---"+jsonObject.getString("processCategory")+"的节点前面没有连线");
				}
				
				if (!keys2.containsKey(key)){
					throw new RuntimeException(jsonObject.getString("processName")+"---"+jsonObject.getString("processCategory")+"的节点后面没有连线");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Date date = new Date(1519833600000l);
		System.out.println(date.toLocaleString());
	}
}
