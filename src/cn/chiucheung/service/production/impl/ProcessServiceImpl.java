package cn.chiucheung.service.production.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.production.standard.ProProcessMapper;
import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTreegridCustom;
import cn.chiucheung.service.production.ProcessService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class ProcessServiceImpl implements ProcessService{
	
	@Autowired
	ProProcessMapper processMapper;
	
	@Override
	public List<ProProcess> findAllProProcessList(ProProcessQueryVo processQueryVo) {
		return processMapper.findAllProProcessList(processQueryVo);
	}

	@Override
	public int saveProProcess(ProProcess process) {
		process.setId(UUIDBuild.getUUID());
		return processMapper.insert(process);
	}

	@Override
	public ProProcess findProProcessById(String id) {
		return processMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateProProcess(ProProcess process) {
		return processMapper.updateByPrimaryKey(process);
	}

	@Override
	public int deleteProProcessById(String id) {
		return processMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProProcess> findAllProcessByDistinct() {
		return processMapper.findAllProcessByDistinct();
	}

	@Override
	public List<ProProcessTreegridCustom> findAllProProcessListForCombotreegrid(ProProcessQueryVo processQueryVo) {
		List<ProProcessTreegridCustom> list = new ArrayList<ProProcessTreegridCustom>();
		List<ProProcessTreegridCustom> processes = processMapper.findAllProProcessListForCombotreegrid(processQueryVo);
		for (ProProcessTreegridCustom process : processes) {
			if (process.getParentProcessNumber() == 0){
				getChildrenNode(processes, process);
				if (StringUtils.isNotBlank(process.getCalculationFormula()) || process.getChildren() != null){//如果计算公式为空，则必须要有子节点，否则没必要展示给combotreegrid，这里的combotreegrid是给用户选择有计算公式的工序
					list.add(process);
				}
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param list 原数据
	 * @param processTreegridCustom 需要setChildren的父节点
	 * @return
	 */
	public void getChildrenNode(List<ProProcessTreegridCustom> list, ProProcessTreegridCustom processTreegridCustom){
		List<ProProcessTreegridCustom> children = new ArrayList<ProProcessTreegridCustom>();
		if (list != null && list.size() > 0){
			for (ProProcessTreegridCustom custom : list) {
				if (custom.getParentProcessNumber().equals(processTreegridCustom.getProcessNumber())){
					getChildrenNode(list, custom);
					if (StringUtils.isNotBlank(custom.getCalculationFormula()) || custom.getChildren() != null){//如果计算公式为空，则必须要有子节点，否则没必要展示给combotreegrid，这里的combotreegrid是给用户选择有计算公式的工序
						children.add(custom);
					}
				}
			}
			if (children.size() > 0){
				processTreegridCustom.setChildren(children);
			}
		}
	}

}
