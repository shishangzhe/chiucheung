package cn.chiucheung.service.engineering.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.engineering.workhours.EngWorkHoursMapper;
import cn.chiucheung.po.engineering.workhours.EngWorkHours;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.workhours.EngExportResultsExcelCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursVo;
import cn.chiucheung.service.engineering.WorkHoursService;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class WorkHoursServiceImpl implements WorkHoursService{
	
	@Autowired
	EngWorkHoursMapper workHoursMapper;

	@Override
	public int saveEngWorkHours(EngWorkHoursCustom workHoursCustom) throws Exception {
		EngWorkHours workHours = new EngWorkHours();
		BeanUtils.copyProperties(workHours, workHoursCustom);
		workHours.setId(UUIDBuild.getUUID());
		String workCardCategory = workHoursCustom.getWorkCardCategory();
		String workCardNo = workHoursCustom.getWorkCardNo();
		String workCardYear = workHoursCustom.getWorkCardYear();
		if ("其他".equals(workCardCategory)){//说明是其他
			workHours.setWorkCardNo(workCardCategory);
		}else{
			if (StringUtils.isBlank(workCardCategory)){
				throw new RuntimeException("工咭类别不能为空");
			}
			if (StringUtils.isBlank(workCardNo) && workCardNo.length() != 4 && !StringUtils.isNumeric(workCardNo)){//说明工咭号为空，并且不是4位，并且不是数字
				throw new RuntimeException("工咭号码不能为空，并且是4位长度的数字");
			}
			if (StringUtils.isBlank(workCardYear) && workCardYear.length() != 2 && !StringUtils.isNumeric(workCardYear)){//说明工咭号年份为空，并且不是2位，并且不是数字，
				throw new RuntimeException("工咭年份不能为空，并且是2位长度的数字");
			}
			workHours.setWorkCardNo(workCardCategory + workCardNo + "-" + workCardYear);
		}
		return workHoursMapper.insert(workHours);
	}

	@Override
	public List<EngWorkHours> findAllWorkHoursList(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.findAllWorkHoursList(workHoursVo);
	}
	
	@Override
	public String findAllWorkHoursTotal(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.findAllWorkHoursTotal(workHoursVo);
	}
	

	@Override
	public String findAllWorkHoursSum(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.findAllWorkHoursSum(workHoursVo);
	}

	@Override
	public EngWorkHoursCustom findEngWorkHoursById(String id) throws Exception {
		EngWorkHoursCustom workHoursCustom = workHoursMapper.findEngWorkHoursById(id);
		if (workHoursCustom != null){
			String wrokCardNo = workHoursCustom.getWorkCardNo();
			if (wrokCardNo.equals("其他")){//工咭号为其他
				workHoursCustom.setWorkCardCategory(wrokCardNo);
				workHoursCustom.setWorkCardNo(null);
			}else if (wrokCardNo.length() == 9){//工咭号已CJ、BJ两位开头的
				workHoursCustom.setWorkCardCategory(wrokCardNo.substring(0, 2));
				workHoursCustom.setWorkCardNo(wrokCardNo.substring(2, 6));
				workHoursCustom.setWorkCardYear(wrokCardNo.substring(7, 9));
			}else{//工咭号已I、Q一位开个头的
				workHoursCustom.setWorkCardCategory(wrokCardNo.substring(0, 1));
				workHoursCustom.setWorkCardNo(wrokCardNo.substring(1, 5));
				workHoursCustom.setWorkCardYear(wrokCardNo.substring(6, 8));
			}
		}else{
			throw new RuntimeException("数据不存在，请刷新数据！");
		}
		return workHoursCustom;
	}

	@Override
	public int updateEngWorkHours(EngWorkHoursCustom workHoursCustom) throws Exception{
		EngWorkHours workHours = new EngWorkHours();
		BeanUtils.copyProperties(workHours, workHoursCustom);
		String workCardCategory = workHoursCustom.getWorkCardCategory();
		String workCardNo = workHoursCustom.getWorkCardNo();
		String workCardYear = workHoursCustom.getWorkCardYear();
		if ("其他".equals(workCardCategory)){//说明是其他
			workHours.setWorkCardNo(workCardCategory);
		}else{
			if (StringUtils.isBlank(workCardCategory)){
				throw new RuntimeException("工咭类别不能为空");
			}
			if (StringUtils.isBlank(workCardNo) && workCardNo.length() != 4 && !StringUtils.isNumeric(workCardNo)){//说明工咭号为空，并且不是4位，并且不是数字
				throw new RuntimeException("工咭号码不能为空，并且是4位长度的数字");
			}
			if (StringUtils.isBlank(workCardYear) && workCardYear.length() != 2 && !StringUtils.isNumeric(workCardYear)){//说明工咭号年份为空，并且不是2位，并且不是数字，
				throw new RuntimeException("工咭年份不能为空，并且是2位长度的数字");
			}
			workHours.setWorkCardNo(workCardCategory + workCardNo + "-" + workCardYear);
		}
		return workHoursMapper.updateByPrimaryKeyWithBLOBs(workHours);
	}

	@Override
	public int deleteEngWorkHoursById(String id) {
		return workHoursMapper.deleteByPrimaryKey(id);
	}

	@Override
	public String checkRemainingTime(EngWorkHours workHours, HttpSession session) {
		if (StringUtils.isBlank(workHours.getId())){//表示新增，用当前用户查询
			SysUser user = UserUtils.getUserFromSession(session);
			workHours.setUserId(user.getId());
		}else{//表示修改，用当前修改的工时对应的用户查询
			EngWorkHours workHours2 = workHoursMapper.selectByPrimaryKey(workHours.getId());
			workHours.setUserId(workHours2.getUserId());
		}
		return workHoursMapper.checkRemainingTime(workHours);
	}

	@Override
	public List<EngExportResultsExcelCustom> exportResultsExcel1(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.exportResultsExcel1(workHoursVo);
	}

	@Override
	public List<EngExportResultsExcelCustom> exportResultsExcel2(EngWorkHoursVo workHoursVo) {
		//数据库查询太慢，用代码的方式
		/*return workHoursMapper.exportResultsExcel2(workHoursVo);*/
		List<EngExportResultsExcelCustom> list = new ArrayList<EngExportResultsExcelCustom>();
		
		List<EngWorkHours> engWorkHours = findAllWorkHoursList(workHoursVo);
		Map<String, EngExportResultsExcelCustom> map = new HashMap<String, EngExportResultsExcelCustom>();
		for (EngWorkHours workHours : engWorkHours) {
			if ((workHours.getWorkCardNo().startsWith("CJ") || workHours.getWorkCardNo().startsWith("BJ")) && !workHours.getWorkContent().equals("验货、跟单") && !workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours1(map.get(workHours.getUserId()).getWorkHours1() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours1(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkCardNo().startsWith("HJ")  && !workHours.getWorkContent().equals("验货、跟单") && !workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours2(map.get(workHours.getUserId()).getWorkHours2() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours2(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if ((workHours.getWorkCardNo().startsWith("Q") || workHours.getWorkCardNo().startsWith("HK")) && !workHours.getWorkContent().equals("验货、跟单") && !workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours3(map.get(workHours.getUserId()).getWorkHours3() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours3(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkCardNo().startsWith("RD")  && !workHours.getWorkContent().equals("验货、跟单") && !workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours4(map.get(workHours.getUserId()).getWorkHours4() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours4(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if ((workHours.getWorkCardNo().startsWith("FG") || workHours.getWorkCardNo().startsWith("SG") || workHours.getWorkCardNo().startsWith("I")) && !workHours.getWorkContent().equals("验货、跟单") && !workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours5(map.get(workHours.getUserId()).getWorkHours5() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours5(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("标准产品资料")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours6(map.get(workHours.getUserId()).getWorkHours6() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours6(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("出差(无单号)") || workHours.getWorkContent().equals("出差(有单号)")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours7(map.get(workHours.getUserId()).getWorkHours7() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours7(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("整理资料")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours8(map.get(workHours.getUserId()).getWorkHours8() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours8(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("待工学习")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours9(map.get(workHours.getUserId()).getWorkHours9() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours9(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("验货、跟单")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours10(map.get(workHours.getUserId()).getWorkHours10() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours10(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("自定义......") || workHours.getWorkContent().equals("临时事物")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours11(map.get(workHours.getUserId()).getWorkHours11() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours11(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}else if (workHours.getWorkContent().equals("休假")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours13(map.get(workHours.getUserId()).getWorkHours13() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours13(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}
			
			//出去休假，所有的工时汇总
			if (!workHours.getWorkContent().equals("休假")){
				if (map.containsKey(workHours.getUserId())){
					map.get(workHours.getUserId()).setWorkHours12(map.get(workHours.getUserId()).getWorkHours12() + workHours.getWorkHours());
				}else{
					EngExportResultsExcelCustom exportResultsExcelCustom = new EngExportResultsExcelCustom();
					exportResultsExcelCustom.setWorkHours12(workHours.getWorkHours());
					map.put(workHours.getUserId(), exportResultsExcelCustom);
				}
			}
		}
		
		for (Entry<String, EngExportResultsExcelCustom> entry : map.entrySet()) {
			entry.getValue().setUsername(entry.getKey());
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public List<EngExportResultsExcelCustom> exportResultsExcel3(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.exportResultsExcel3(workHoursVo);
	}

	@Override
	public List<EngExportResultsExcelCustom> exportResultsExcel4(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.exportResultsExcel4(workHoursVo);
	}

	@Override
	public List<EngExportResultsExcelCustom> exportResultsExcel5(EngWorkHoursVo workHoursVo) {
		return workHoursMapper.exportResultsExcel5(workHoursVo);
	}

	@Override
	public List<SysUser> selectEngReviewer() {
		return workHoursMapper.selectEngReviewer();
	}

}
