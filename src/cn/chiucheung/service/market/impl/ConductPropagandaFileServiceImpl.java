package cn.chiucheung.service.market.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.dao.mapper.market.conductpropagandafile.MarConductPropagandaFileMapper;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFileExample;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFileExample.Criteria;
import cn.chiucheung.pojo.market.conductpropagandafile.MarConductPropagandaFileQueryVo;
import cn.chiucheung.service.market.ConductPropagandaFileService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class ConductPropagandaFileServiceImpl implements ConductPropagandaFileService{
	
	@Autowired
	MarConductPropagandaFileMapper conductPropagandaFileMapper;
	
	@Override
	public List<MarConductPropagandaFile> findAllConductPropagandaFile(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo) {
		return conductPropagandaFileMapper.findAllConductPropagandaFile(conductPropagandaFileQueryVo);
	}

	@Override
	public String findAllConductPropagandaFileTotal(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo) {
		return conductPropagandaFileMapper.findAllConductPropagandaFileTotal(conductPropagandaFileQueryVo);
	}
	

	@Override
	public List<MarConductPropagandaFile> findAllOldConductPropagandaFileByNewId(String id) {
		MarConductPropagandaFile conductPropagandaFile = conductPropagandaFileMapper.selectByPrimaryKey(id);
		
		MarConductPropagandaFileExample example = new MarConductPropagandaFileExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andFileNameEqualTo(conductPropagandaFile.getFileName());
		List<String> values = new ArrayList<String>();
		values.add(id);
		createCriteria.andIdNotIn(values);
		example.setOrderByClause("file_version");
		return conductPropagandaFileMapper.selectByExample(example);
	}

	@Override
	public int saveConductPropagandaFile(MultipartFile file) throws Exception{
		
		MarConductPropagandaFileExample example = new MarConductPropagandaFileExample();
		example.createCriteria().andFileNameEqualTo("file.getOriginalFilename()");
		List<MarConductPropagandaFile> list = conductPropagandaFileMapper.selectByExample(example);
		
		if (list != null && list.size() > 0){
			throw new RuntimeException("已存在该文件");
		}
        
        File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path"),"marConductPropagandaFile");
        if (!fileDir.exists()){
        	fileDir.mkdirs();
        }

        MarConductPropagandaFile conductPropagandaFile = new MarConductPropagandaFile();
        conductPropagandaFile.setId(UUIDBuild.getUUID());
        conductPropagandaFile.setFileName(file.getOriginalFilename());
        conductPropagandaFile.setFileVersion(1.0f);
        conductPropagandaFile.setCreateTime(new Date());
        
        file.transferTo(new File(ResourcesUtil.getValue("fileRootPath", "path") + "/marConductPropagandaFile/" + conductPropagandaFile.getId()));
        
        
		return conductPropagandaFileMapper.insert(conductPropagandaFile);
	}
	

	@Override
	public List<MarConductPropagandaFile> checkFileNameIsRepeat(String fileName) {
		MarConductPropagandaFileExample conductPropagandaFileExample = new MarConductPropagandaFileExample();
		conductPropagandaFileExample.createCriteria().andFileNameEqualTo(fileName);
		return conductPropagandaFileMapper.selectByExample(conductPropagandaFileExample);
	}

	@Override
	public int updateConductPropagandaFile(String fileName, MultipartFile file) throws Exception{
		MarConductPropagandaFile conductPropagandaFile = new MarConductPropagandaFile();
		
		
		MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo = new MarConductPropagandaFileQueryVo();
		conductPropagandaFileQueryVo.setFileName(fileName);
		List<MarConductPropagandaFile> maxConductPropagandaFiles = conductPropagandaFileMapper.findAllConductPropagandaFile(conductPropagandaFileQueryVo);
		
		if (maxConductPropagandaFiles == null || maxConductPropagandaFiles.size() <= 0){
			throw new RuntimeException("未找到要更新的宣传文件");
		}
		
		File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path"),"marConductPropagandaFile");
        if (!fileDir.exists()){
        	fileDir.mkdirs();
        }
        
        conductPropagandaFile.setId(UUIDBuild.getUUID());
        conductPropagandaFile.setFileVersion(maxConductPropagandaFiles.get(0).getFileVersion()+0.1f);
        conductPropagandaFile.setCreateTime(new Date());
        conductPropagandaFile.setFileName(fileName);
        
        file.transferTo(new File(ResourcesUtil.getValue("fileRootPath", "path") + "/marConductPropagandaFile/" + conductPropagandaFile.getId()));
        
		return conductPropagandaFileMapper.insert(conductPropagandaFile);
	}

	@Override
	public int deleteConductPropagandaFileById(String id) throws Exception{
		MarConductPropagandaFile conductPropagandaFile = conductPropagandaFileMapper.selectByPrimaryKey(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/marConductPropagandaFile/" + conductPropagandaFile.getId());
		
		if (file.exists()){//如果文件存在
			if (!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
		}
		
		return conductPropagandaFileMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MarConductPropagandaFile findConductPropagandaFileById(String id) {
		return conductPropagandaFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MarConductPropagandaFile> findMaxVersionFormConductPropagandaFileByFileName(String fileName) {
		MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo = new MarConductPropagandaFileQueryVo();
		conductPropagandaFileQueryVo.setFileName(fileName);
		return conductPropagandaFileMapper.findAllConductPropagandaFile(conductPropagandaFileQueryVo);
	}

	@Override
	public List<MarConductPropagandaFile> findConductPropagandaFileList() {
		return conductPropagandaFileMapper.findConductPropagandaFileList();
	}

}
