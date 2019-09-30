package cn.chiucheung.service.finance.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.chiucheung.dao.mapper.finance.planetrainticket.FinPlaneTrainTicketMapper;
import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicket;
import cn.chiucheung.pojo.finance.planetrainticket.FinPlaneTrainTicketQueryVo;
import cn.chiucheung.service.finance.PlaneTrainTicketService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class PlaneTrainTicketServiceImpl implements PlaneTrainTicketService{
	
	@Autowired
	private FinPlaneTrainTicketMapper planeTrainTicketMapper;

	@Override
	public List<FinPlaneTrainTicket> findAllPlaneTrainTicketList(FinPlaneTrainTicketQueryVo trainTicketQueryVo) {
		return planeTrainTicketMapper.findAllPlaneTrainTicketList(trainTicketQueryVo);
	}

	@Override
	public String findAllPlaneTrainTicketTotal(FinPlaneTrainTicketQueryVo trainTicketQueryVo) {
		return planeTrainTicketMapper.findAllPlaneTrainTicketTotal(trainTicketQueryVo);
	}

	@Override
	public int savePlaneTrainTicket(FinPlaneTrainTicket planeTrainTicket) {
		planeTrainTicket.setId(UUIDBuild.getUUID());
		return planeTrainTicketMapper.insert(planeTrainTicket);
	}

	@Override
	public FinPlaneTrainTicket findPlaneTrainTicketById(String id) {
		FinPlaneTrainTicket planeTrainTicket = planeTrainTicketMapper.selectByPrimaryKey(id);
		/*if (planeTrainTicket == null){
			throw new RuntimeException("未找到要更新的数据");
		}
		if (planeTrainTicket.getIsLock() || planeTrainTicket.getIsReceiveReceipt()){
			throw new RuntimeException("已报账或已收发票，不能修改");
		}*/
		return planeTrainTicket;
	}

	@Override
	public int updatePlaneTrainTicket(FinPlaneTrainTicket planeTrainTicket) {
		if (StringUtils.isNotBlank(planeTrainTicket.getId())){
			FinPlaneTrainTicket planeTrainTicket1 = planeTrainTicketMapper.selectByPrimaryKey(planeTrainTicket.getId());
			if (planeTrainTicket1 == null){
				throw new RuntimeException("未找到要更新的数据");
			}
			if (planeTrainTicket1.getIsLock() || planeTrainTicket1.getIsReceiveReceipt()){
				if (planeTrainTicket.getIsLock() == planeTrainTicket1.getIsLock() && planeTrainTicket.getIsReceiveReceipt() == planeTrainTicket1.getIsReceiveReceipt()){
					FinPlaneTrainTicket planeTrainTicket2 = new FinPlaneTrainTicket();
					planeTrainTicket2.setId(planeTrainTicket.getId());
					planeTrainTicket2.setRemark(planeTrainTicket.getRemark());
					return planeTrainTicketMapper.updateByPrimaryKeySelective(planeTrainTicket2);
				}else{
					throw new RuntimeException("数据更新了，请刷新后在修改！");
				}
			}else{
				return planeTrainTicketMapper.updateByPrimaryKey(planeTrainTicket);
			}
		}else{
			throw new RuntimeException("更新的id不能为空");
		}
	}

	@Override
	public int deletePlaneTrainTicketById(String id) {
		if (StringUtils.isNotBlank(id)){
			FinPlaneTrainTicket planeTrainTicket = planeTrainTicketMapper.selectByPrimaryKey(id);
			if (planeTrainTicket == null){
				throw new RuntimeException("未找到要删除的数据");
			}
			if (planeTrainTicket.getIsLock() || planeTrainTicket.getIsReceiveReceipt()){
				throw new RuntimeException("已报账或已收发票，不能删除");
			}
			return planeTrainTicketMapper.deleteByPrimaryKey(id);
		}else{
			throw new RuntimeException("更新的id不能为空");
		}
	}

	@Override
	public int updatePlaneTrainTicketByIdForLock(FinPlaneTrainTicket planeTrainTicket) {
		return planeTrainTicketMapper.updatePlaneTrainTicketByIdForLock(planeTrainTicket);
	}

	@Override
	public int updatePlaneTrainTicketByIdForReceiveReceipt(FinPlaneTrainTicket planeTrainTicket) {
		return planeTrainTicketMapper.updatePlaneTrainTicketByIdForReceiveReceipt(planeTrainTicket);
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
		ArrayList<List<String>> list = new ArrayList<List<String>>();
		
		List<FinPlaneTrainTicket> planeTrainTickets = new ArrayList<FinPlaneTrainTicket>();
		
		try {
			if (f == null && f.length() <= 0) {
				throw new Exception("文件为空！");
			}

			in = new FileInputStream(f);//将文件读入到输入流中
			
			wb = Workbook.getWorkbook(in);//从输入流中获取WorkBook对象，加载选中的excel文件
			Sheet sheet[] = wb.getSheets();//通过workbook对象获取sheet对象，此时sheet对象是一个数组
			if (sheet != null && sheet.length > 0) {
				for (int i = 3; i < sheet[0].getRows(); i++) {//使用sheet对象用来获取每1行，从1开始表示要去掉excel的标题
					List<String> valStr = new ArrayList<String>();
					for (int j = 0; j < sheet[0].getColumns(); j++) {//使用sheet对象用来获取每1列，从0开始表示从第1列开始
						Cell cell = sheet[0].getCell(j, i);//k表示列的号，j表示行的号
						String content = "";
						String tempcontent = (cell.getContents() == null ? "" : cell.getContents());
						content = tempcontent.trim();
						/*if (cell.getType() == CellType.DATE) {
							DateCell dateCell = (DateCell) cell;
							java.util.Date importdate = dateCell.getDate();*//**如果excel是日期格式的话需要减去8小时*//*
							long eighthour = 8*60*60*1000;
							SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
							*//**在当前日期上减8小时*//*
							long time = importdate.getTime()-eighthour; 
							java.util.Date date = new java.util.Date();
							date.setTime(time);
							content = simpledate.format(date); 
						} else {
							String tempcontent = (cell.getContents() == null ? "" : cell.getContents());
							content = tempcontent.trim();
						}*/
						valStr.add(content);//将excel获取到的值赋值给String类型的数组
					} 
					list.add(valStr);
				}
			}else{
				throw new Exception("表为空！");
			}
			if (list != null && list.size() > 0){
				for (int i=0; i<list.size(); i++) {
					List<String> strings = list.get(i);
					
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					FinPlaneTrainTicket planeTrainTicket = new FinPlaneTrainTicket();
					planeTrainTicket.setId(UUIDBuild.getUUID());
					String workCardNo = "";
					if (StringUtils.isNotBlank(strings.get(0)) && StringUtils.isNotBlank(strings.get(1)) && StringUtils.isNotBlank(strings.get(2))){
						workCardNo = strings.get(0)+strings.get(1)+"-"+strings.get(2).substring(strings.get(2).length()-2, strings.get(2).length());
					}else{
						workCardNo = "无工咭";
					}
					planeTrainTicket.setWorkCardNo(workCardNo);
					planeTrainTicket.setTrafficType("火车");
					try {
						planeTrainTicket.setOrderTicketsDate(format1.parse(strings.get(5) + "-" + strings.get(4) + "-" + strings.get(3)));
						if (StringUtils.isNotBlank(strings.get(6))){
							strings.get(6);
						}else{
							strings.set(6, "00:00");
						}
						planeTrainTicket.setDepartureTime(format2.parse(strings.get(9) + "-" + strings.get(8) + "-" + strings.get(7) + " " + strings.get(6) + ":00"));
					} catch (ParseException e) {
						throw new RuntimeException(4+i+"行的日期格式错误");
					}
					planeTrainTicket.setTravelPersonnel(strings.get(10));
					planeTrainTicket.setStartPoint(strings.get(11));
					planeTrainTicket.setEndPoint(strings.get(12));
					planeTrainTicket.setPlaneTrainNumber(strings.get(13));
					planeTrainTicket.setSeat(strings.get(14));
					planeTrainTicket.setBerth(strings.get(15));
					planeTrainTicket.setPrice(Float.parseFloat(strings.get(16)));
					planeTrainTicket.setOrderNumber(strings.get(17));
					planeTrainTicket.setRemark(strings.get(18));
					
					planeTrainTicket.setIsLock(true);
					planeTrainTicket.setIsReceiveReceipt(true);
					
					planeTrainTickets.add(planeTrainTicket);
					
				}
			}
			count = planeTrainTicketMapper.insertList(planeTrainTickets);
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

	@Override
	public FinPlaneTrainTicket copyPlaneTrainTicketById(String id) {
		return planeTrainTicketMapper.selectByPrimaryKey(id);
	}

}
