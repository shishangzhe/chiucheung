package cn.chiucheung.service.finance.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.chiucheung.dao.mapper.finance.workcardinfo.FinWorkCardInfoMapper;
import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForGenerateExcel;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForUpdateCustom;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoQueryVo;
import cn.chiucheung.service.finance.WorkCardInfoService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class WorkCardInfoServiceImpl implements WorkCardInfoService{
	
	@Autowired FinWorkCardInfoMapper workCardInfoMapper;
	
	@Override
	public List<FinWorkCardInfoForUpdateCustom> findAllWorkCardInfoList(FinWorkCardInfoQueryVo workCardInfoQueryVo) {
		return workCardInfoMapper.findAllWorkCardInfoList(workCardInfoQueryVo);
	}

	@Override
	public String findAllWorkCardInfoTotal(FinWorkCardInfoQueryVo workCardInfoQueryVo) {
		return workCardInfoMapper.findAllWorkCardInfoTotal(workCardInfoQueryVo);
	}

	@Override
	public int saveWorkCardInfo(FinWorkCardInfo workCardInfo) {
		workCardInfo.setId(UUIDBuild.getUUID());
		return workCardInfoMapper.insertSelective(workCardInfo);
	}

	@Override
	public FinWorkCardInfo findWorkCardInfoById(FinWorkCardInfoQueryVo workCardInfoQueryVo) {
		return workCardInfoMapper.findWorkCardInfoById(workCardInfoQueryVo);
	}

	@Override
	public int updateWorkCardInfo(FinWorkCardInfoForUpdateCustom workCardInfoForUpdateCustom) {
		return workCardInfoMapper.updateWorkCardInfo(workCardInfoForUpdateCustom);
	}

	@Override
	public int deleteWorkCardInfoById(String id) {
		return workCardInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<FinWorkCardInfoForGenerateExcel> FindAllCompletionWorkCardCostForGenerateExcel(FinWorkCardInfoQueryVo workCardInfoQueryVo) {
		List<FinWorkCardInfoForGenerateExcel> list = workCardInfoMapper.FindAllCompletionWorkCardCostForGenerateExcel(workCardInfoQueryVo);
		for (FinWorkCardInfoForGenerateExcel workCardInfoForGenerateExcel : list) {
			BigDecimal trafficCost = workCardInfoMapper.calculationTrafficCostInInstallationPersonnel(workCardInfoForGenerateExcel);
			workCardInfoForGenerateExcel.setTrafficCost(trafficCost);
		}
		return list;
	}

	@Override
	public int insertListForImportExcel(MultipartFile uploadFile) throws Exception{
		int count = 0;
		
		CommonsMultipartFile cf= (CommonsMultipartFile)uploadFile; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation(); 
        //读取Excel
        InputStream in = null;
		Workbook wb = null;   //jxl的核心对象
		
		List<FinWorkCardInfo> list = new ArrayList<FinWorkCardInfo>();
		
		try {
			if (f == null && f.length() <= 0) {
				throw new Exception("文件为空！");
			}

			in = new FileInputStream(f);//将文件读入到输入流中
			
			wb = Workbook.getWorkbook(in);//从输入流中获取WorkBook对象，加载选中的excel文件
			Sheet sheet[] = wb.getSheets();//通过workbook对象获取sheet对象，此时sheet对象是一个数组
			if (sheet != null && sheet.length > 0) {
				for(int i=0;i<sheet.length;i++){
					for (int j=1;j<sheet[i].getRows();j++){
						FinWorkCardInfo workCardInfo = new FinWorkCardInfo();
						workCardInfo.setId(UUIDBuild.getUUID());
						workCardInfo.setWorkCardNo(sheet[i].getCell(0, j).getContents());
						workCardInfo.setProjectLeader(sheet[i].getCell(1, j).getContents());
						if (StringUtils.isNotBlank(sheet[i].getCell(2, j).getContents())){
							workCardInfo.setContractAmount(new BigDecimal(sheet[i].getCell(2, j).getContents().replace(",", "")));
						}
						if (StringUtils.isNotBlank(sheet[i].getCell(3, j).getContents())){
							workCardInfo.setExpectedInstallationCost(new BigDecimal(sheet[i].getCell(3, j).getContents().replace(",", "")));
						}
						if (sheet[i].getCell(4, j).getType() == CellType.DATE) {
							DateCell dateCell = (DateCell)(sheet[i].getCell(4, j));
							workCardInfo.setCompletionDate(dateCell.getDate());
						}
						
						list.add(workCardInfo);
					}
				}
			}else{
				throw new Exception("表为空！");
			}
			count = workCardInfoMapper.insertList(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		return count;
	}

}
