package cn.chiucheung.service.warehouse.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.dao.mapper.warehouse.standardaccessories.WarStandardAccessoriesFileMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessories.WarStandardAccessoriesMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventoryMapper;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFileExample;
import cn.chiucheung.po.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventory;
import cn.chiucheung.po.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventoryExample;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.warehouse.StandardAccessoriesService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class StandardAccessoriesServiceImpl implements StandardAccessoriesService{
	
	@Autowired
	private WarStandardAccessoriesMapper standardAccessoriesMapper;
	
	@Autowired
	private WarStandardAccessoriesInventoryMapper standardAccessoriesInventoryMapper;
	
	@Autowired
	private WarStandardAccessoriesFileMapper standardAccessoriesFileMapper;
	
	@Override
	public int saveWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment) throws Exception{
		standardAccessories.setId(UUIDBuild.getUUID());
		int i = 0;
		i = i + standardAccessoriesMapper.insert(standardAccessories);
		
		WarStandardAccessoriesInventory standardAccessoriesInventory = new WarStandardAccessoriesInventory();
		standardAccessoriesInventory.setId(UUIDBuild.getUUID());
		standardAccessoriesInventory.setExistingQuantity(0);
		standardAccessoriesInventory.setWarStandardAccessoriesId(standardAccessories.getId());
		
		i = i + standardAccessoriesInventoryMapper.insert(standardAccessoriesInventory);
		
		if (attachment.getSize() > 0){
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path"), "/warStandardAccessories");
			if (!file.exists()){
				file.mkdirs();
			}
			
			WarStandardAccessoriesFile standardAccessoriesFile = new WarStandardAccessoriesFile();
			standardAccessoriesFile.setId(UUIDBuild.getUUID());
			standardAccessoriesFile.setFileName(attachment.getOriginalFilename());
			String suffix = attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf("."), attachment.getOriginalFilename().length());
			standardAccessoriesFile.setFilePath(UUIDBuild.getUUID()+suffix);
			try{
				attachment.transferTo(new File(file, standardAccessoriesFile.getFilePath()));
			}catch (FileNotFoundException e){
				throw new RuntimeException(e);
			}
			standardAccessoriesFile.setWarStandardAccessoriesId(standardAccessories.getId());
			standardAccessoriesFileMapper.insert(standardAccessoriesFile);
		}
		
		return i;
	}

	@Override
	public List<WarStandardAccessoriesCustom> findAllWarStandardAccessoriesList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return standardAccessoriesMapper.findAllWarStandardAccessoriesList(standardAccessoriesQueryVo);
	}

	@Override
	public String findAllWarStandardAccessoriesTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return standardAccessoriesMapper.findAllWarStandardAccessoriesTotal(standardAccessoriesQueryVo);
	}
	
	@Override
	public WarStandardAccessoriesFile findfindWarStandardAccessoriesFileById(String id) {
		return standardAccessoriesFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public WarStandardAccessories findWarStandardAccessoriesByIdForEdit(String id) {
		return standardAccessoriesMapper.selectByPrimaryKey(id);
	}

	@Override
	public WarStandardAccessoriesFile findWarStandardAccessoriesFileByWarStandardAccessoriesId(String warStandardAccessoriesId) {
		WarStandardAccessoriesFileExample standardAccessoriesFileExample = new WarStandardAccessoriesFileExample();
		standardAccessoriesFileExample.createCriteria().andWarStandardAccessoriesIdEqualTo(warStandardAccessoriesId);
		List<WarStandardAccessoriesFile> standardAccessoriesFiles = standardAccessoriesFileMapper.selectByExample(standardAccessoriesFileExample);
		if (standardAccessoriesFiles.size() > 0){
			return standardAccessoriesFiles.get(0);
		}
		return null;
	}

	@Override
	public int deleteWarStandardAccessoriesFileById(String id) {
		WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesFileMapper.selectByPrimaryKey(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/warStandardAccessories", standardAccessoriesFile.getFilePath());
		if (file.exists()){
			if(!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
		}
		return standardAccessoriesFileMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment) throws Exception{
		int i = 0;
		i = i + standardAccessoriesMapper.updateByPrimaryKey(standardAccessories);
		if (attachment.getSize() > 0){
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path"), "/warStandardAccessories");
			if (!file.exists()){
				file.mkdirs();
			}
			
			WarStandardAccessoriesFile standardAccessoriesFile = new WarStandardAccessoriesFile();
			standardAccessoriesFile.setId(UUIDBuild.getUUID());
			standardAccessoriesFile.setFileName(attachment.getOriginalFilename());
			String suffix = attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf("."), attachment.getOriginalFilename().length());
			standardAccessoriesFile.setFilePath(UUIDBuild.getUUID()+suffix);
			try{
				attachment.transferTo(new File(file, standardAccessoriesFile.getFilePath()));
			}catch (FileNotFoundException e){
				throw new RuntimeException(e);
			}
			standardAccessoriesFile.setWarStandardAccessoriesId(standardAccessories.getId());
			standardAccessoriesFileMapper.insert(standardAccessoriesFile);
		}
		return i;
	}

	@Override
	public int deleteWarStandardAccessoriesById(String id) {
		int i = 0;
		
		WarStandardAccessoriesInventoryExample standardAccessoriesInventoryExample = new WarStandardAccessoriesInventoryExample();
		standardAccessoriesInventoryExample.createCriteria().andWarStandardAccessoriesIdEqualTo(id);
		List<WarStandardAccessoriesInventory> standardAccessoriesInventories = standardAccessoriesInventoryMapper.selectByExample(standardAccessoriesInventoryExample);
		if (standardAccessoriesInventories.get(0).getExistingQuantity() > 0){
			throw new RuntimeException("库存不为0，不能删除");
		}
		standardAccessoriesInventoryMapper.deleteByExample(standardAccessoriesInventoryExample);
		
		WarStandardAccessoriesFileExample standardAccessoriesFileExample = new WarStandardAccessoriesFileExample();
		standardAccessoriesFileExample.createCriteria().andWarStandardAccessoriesIdEqualTo(id);
		List<WarStandardAccessoriesFile> standardAccessoriesFiles = standardAccessoriesFileMapper.selectByExample(standardAccessoriesFileExample);
		if (standardAccessoriesFiles.size() > 0){
			WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesFiles.get(0);
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/warStandardAccessories", standardAccessoriesFile.getFilePath());
			if(!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
			i = i + standardAccessoriesFileMapper.deleteByExample(standardAccessoriesFileExample);
		}
		i = i + standardAccessoriesMapper.deleteByPrimaryKey(id);
		return i;
	}

}
