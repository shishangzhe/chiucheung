package cn.chiucheung.service.sales.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.chiucheung.dao.mapper.sales.projectinfo.SalProjectInfoMapper;
import cn.chiucheung.dao.mapper.sales.projectinfo.SalProjectInfoPicMapper;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfo;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoExample;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPic;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPicExample;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPicExample.Criteria;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoCustom;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;
import cn.chiucheung.service.sales.ProjectInfoService;
import cn.chiucheung.utils.ImageUtil;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService{
	
	@Autowired
	SalProjectInfoMapper projectInfoMapper;
	
	@Autowired
	SalProjectInfoPicMapper projectInfoPicMapper;
	
	@Override
	public List<SalProjectInfoCustom> findAllProjectInfoList(SalProjectInfoQueryVo projectInfoQueryVo) {
		return projectInfoMapper.findAllProjectInfoList(projectInfoQueryVo);
	}

	@Override
	public String findAllProjectInfoTotal(SalProjectInfoQueryVo projectInfoQueryVo) {
		return projectInfoMapper.findAllProjectInfoTotal(projectInfoQueryVo);
	}

	@Override
	public int saveSalProjectInfo(SalProjectInfo projectInfo, MultipartFile[] pic) throws Exception{
		List<SalProjectInfoPic> list = new ArrayList<SalProjectInfoPic>();
		
		String id = UUIDBuild.getUUID();
		projectInfo.setId(id);
		if (pic != null && pic.length > 0){
			File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo");
	        if (!fileDir.exists()){
	        	fileDir.mkdirs();
	        }
	        File fileDir2 = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails");
        	if (!fileDir2.exists()){
	        	fileDir2.mkdirs();
	        }
        	
	        
	        try{
		        for (MultipartFile multipartFile : pic) {
		        	if (multipartFile.getSize() > 0){
			        	SalProjectInfoPic projectInfoPic = new SalProjectInfoPic();
			        	String projectInfoPicId = UUIDBuild.getUUID();
			        	projectInfoPic.setId(projectInfoPicId);
			        	projectInfoPic.setSalProjectInfoId(id);
			        	
			        	File file = new File(fileDir, projectInfoPicId + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	multipartFile.transferTo(file);
			        	
			        	projectInfoPic.setSuffix(multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	
			        	list.add(projectInfoPic);
			        	
			        	File file2 = new File(fileDir2, projectInfoPicId + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	ImageUtil.thumbnailImage(file.getPath(), 160, file2.getPath());
		        	}
		        	
				}
	        }catch (Exception e){
	        	for (SalProjectInfoPic projectInfoPic : list) {
	        		new File(fileDir, projectInfoPic.getId()+projectInfoPic.getSuffix()).delete();
	        		new File(fileDir2, projectInfoPic.getId()+projectInfoPic.getSuffix()).delete();
				}
	        	throw e;
	        }
	        
		}
		int i = projectInfoMapper.insert(projectInfo);
		
		if (list != null && list.size() > 0){
			projectInfoPicMapper.insertList(list);
		}
		
		return i;
	}

	@Override
	public SalProjectInfoCustom findSalProjectInfoById(String id) throws Exception{
		SalProjectInfoQueryVo projectInfoQueryVo = new SalProjectInfoQueryVo();
		projectInfoQueryVo.setId(id);
		
		return projectInfoMapper.findAllProjectInfoList(projectInfoQueryVo).get(0);
	}

	@Override
	public int updateSalProjectInfo(SalProjectInfo projectInfo, MultipartFile[] pic) throws Exception{
		List<SalProjectInfoPic> list = new ArrayList<SalProjectInfoPic>();
		
		String id = projectInfo.getId();
		if (pic != null && pic.length > 0){
			File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo");
	        if (!fileDir.exists()){
	        	fileDir.mkdirs();
	        }
	        File fileDir2 = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails");
        	if (!fileDir2.exists()){
	        	fileDir2.mkdirs();
	        }
        	
	        
	        try{
		        for (MultipartFile multipartFile : pic) {
		        	if (multipartFile.getSize() > 0){
			        	SalProjectInfoPic projectInfoPic = new SalProjectInfoPic();
			        	String projectInfoPicId = UUIDBuild.getUUID();
			        	projectInfoPic.setId(projectInfoPicId);
			        	projectInfoPic.setSalProjectInfoId(id);
			        	
			        	File file = new File(fileDir, projectInfoPicId + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	multipartFile.transferTo(file);
			        	
			        	projectInfoPic.setSuffix(multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	
			        	list.add(projectInfoPic);
			        	
			        	File file2 = new File(fileDir2, projectInfoPicId + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length()));
			        	ImageUtil.thumbnailImage(file.getPath(), 160, file2.getPath());
		        	}
		        	
				}
	        }catch (Exception e){
	        	for (SalProjectInfoPic projectInfoPic : list) {
	        		new File(fileDir, projectInfoPic.getId()+projectInfoPic.getSuffix()).delete();
	        		new File(fileDir2, projectInfoPic.getId()+projectInfoPic.getSuffix()).delete();
				}
	        	throw e;
	        }
	        
		}
		int i = projectInfoMapper.updateByPrimaryKey(projectInfo);
		
		if (list != null && list.size() > 0){
			projectInfoPicMapper.insertList(list);
		}
		
		return i;
	}

	@Override
	public int deleteSalProjectInfoById(String id) {
		SalProjectInfoPicExample example = new SalProjectInfoPicExample();
		Criteria criteria = example.createCriteria();
		criteria.andSalProjectInfoIdEqualTo(id);
		
		List<SalProjectInfoPic> pics = projectInfoPicMapper.selectByExample(example);
		if (pics != null && pics.size() > 0){
			throw new RuntimeException("请先删除图片，再删除该记录");
		}
		return projectInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SalProjectInfoPic findSalProjectInfoPicById(String id) {
		return projectInfoPicMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteSalProjectInfoPicById(String id) throws Exception{
		SalProjectInfoPic projectInfoPic = projectInfoPicMapper.selectByPrimaryKey(id);
		
		File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo");
		File file = new File(fileDir, id+projectInfoPic.getSuffix());
		file.delete();
		
		File fileDir2 = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails");
		File file2 = new File(fileDir2, id+projectInfoPic.getSuffix());
		file2.delete();
		
		return projectInfoPicMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertListForImportExcel(MultipartFile excel) throws Exception {
		int count = 0;
		
		CommonsMultipartFile cf= (CommonsMultipartFile)excel; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation(); 
        //读取Excel
        InputStream in = null;
		Workbook wb = null;   //jxl的核心对象
		ArrayList<List<String>> list = new ArrayList<List<String>>();
		
		List<SalProjectInfo> projectInfos = new ArrayList<SalProjectInfo>();
		
		try {
			if (f == null && f.length() <= 0) {
				throw new Exception("文件为空！");
			}

			in = new FileInputStream(f);//将文件读入到输入流中
			
			wb = Workbook.getWorkbook(in);//从输入流中获取WorkBook对象，加载选中的excel文件
			Sheet sheet[] = wb.getSheets();//通过workbook对象获取sheet对象，此时sheet对象是一个数组
			if (sheet != null && sheet.length > 0) {
				for (int i = 1; i < sheet[0].getRows(); i++) {//使用sheet对象用来获取每1行，从1开始表示要去掉excel的标题
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
					
					SalProjectInfo projectInfo = new SalProjectInfo();
					projectInfo.setId(UUIDBuild.getUUID());
					projectInfo.setWorkCardNo(strings.get(0));
					String year = strings.get(1).trim();
					year = year.contains("年") ? year.replace("年", "") : year;
					projectInfo.setYear(Integer.valueOf(year));
					projectInfo.setCountry(StringUtils.isNotBlank(strings.get(2)) ? strings.get(2) : "中国");
					projectInfo.setProvince(strings.get(3));
					projectInfo.setCity(strings.get(4));
					projectInfo.setIndustry(strings.get(5));
					projectInfo.setCustom(strings.get(6));
					
					
					projectInfos.add(projectInfo);
				}
			}
			count = projectInfoMapper.insertList(projectInfos);
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
	public List<SalProjectInfo> findAllProjectInfoListForExport() {
		return projectInfoMapper.selectByExample(null);
	}

	@Override
	public int insertPicByDirectory() throws Exception{
		int i = 0; 
		
		File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo");
        if (!fileDir.exists()){
        	fileDir.mkdirs();
        }
        File fileDir2 = new File(ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails");
    	if (!fileDir2.exists()){
        	fileDir2.mkdirs();
        }
    	
		File file = new File("G:\\电子沙盘\\项目图片");
		File[] files = file.listFiles();
		
		for (File workCardNoFile : files) {
			SalProjectInfoExample example = new SalProjectInfoExample();
			example.createCriteria().andWorkCardNoEqualTo(workCardNoFile.getName());
			List<SalProjectInfo> list = projectInfoMapper.selectByExample(example);
			if (list != null && list.size() > 0){
				File[] picFiles = workCardNoFile.listFiles();
				if (picFiles != null && picFiles.length > 0){
					List<SalProjectInfoPic> projectInfoPics = new ArrayList<SalProjectInfoPic>();
					for (File picFile : picFiles) {
						SalProjectInfoPic projectInfoPic = new SalProjectInfoPic();
						projectInfoPic.setId(UUIDBuild.getUUID());
						projectInfoPic.setSuffix(picFile.getName().substring(picFile.getName().lastIndexOf("."), picFile.getName().length()));
						projectInfoPic.setSalProjectInfoId(list.get(0).getId());
						projectInfoPics.add(projectInfoPic);
						
						File file2 = new File(fileDir, projectInfoPic.getId() + projectInfoPic.getSuffix());
						FileUtils.copyFile(picFile, file2);
						//picFile.renameTo(file2);
						
						String path = new File(fileDir2, projectInfoPic.getId() + projectInfoPic.getSuffix()).getPath();
						ImageUtil.thumbnailImage(file2.getPath(), 160, path);
					}
					i += projectInfoPicMapper.insertList(projectInfoPics);
				}
			}
		}
		return i;
	}

}
