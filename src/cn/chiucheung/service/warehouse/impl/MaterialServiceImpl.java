package cn.chiucheung.service.warehouse.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.dao.mapper.warehouse.material.WarMaterialFileMapper;
import cn.chiucheung.dao.mapper.warehouse.material.WarMaterialMapper;
import cn.chiucheung.dao.mapper.warehouse.materialinventory.WarMaterialInventoryMapper;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialExample;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.po.warehouse.material.WarMaterialFileExample;
import cn.chiucheung.po.warehouse.materialinventory.WarMaterialInventory;
import cn.chiucheung.po.warehouse.materialinventory.WarMaterialInventoryExample;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Service("warMaterialService")
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	private WarMaterialMapper materialMapper;
	
	@Autowired
	private WarMaterialFileMapper materialFileMapper;
	
	@Autowired
	private WarMaterialInventoryMapper materialInventoryMapper;


	@Override
	public List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo) {
		if (materialQueryVo.getIsQuery()){//使用高级搜索的时候，则不以树形菜单展示
			return materialMapper.findAllWarMaterialList(materialQueryVo);
		}else{
			if (StringUtils.isNotBlank(materialQueryVo.getMaterialCodeForExpand())){//用于展开的查询
				return materialMapper.findAllWarMaterialList(materialQueryVo);
			}else{
				materialQueryVo.setState("closed");
				List<WarMaterial> materials = materialMapper.findAllWarMaterialList(materialQueryVo);
				if (materials != null && materials.size() >0){
					for (WarMaterial material : materials) {
						material.setChildren(findAllMaterialSubsidiaryList(material, materialQueryVo));
					}
				}
				return materials;
			}
		}
	}
	
	private List<WarMaterial> findAllMaterialSubsidiaryList(WarMaterial material2, WarMaterialQueryVo materialQueryVo){
		materialQueryVo.setMaterialCodeForExpand(material2.getMaterialCode());
		materialQueryVo.setLevel(material2.getMaterialCode().length() - material2.getMaterialCode().replace(".", "").length() + 1);
		List<WarMaterial> materials = materialMapper.findAllWarMaterialList(materialQueryVo);
		if (materials != null && materials.size() >0){
			for (WarMaterial material : materials) {
				material.setChildren(findAllMaterialSubsidiaryList(material, materialQueryVo));
			}
		}
		return materials;
	}

	@Override
	public String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo) {
		return materialMapper.findAllWarMaterialTotal(materialQueryVo);
	}

	@Override
	public String saveMaterial(WarMaterial material, MultipartFile attachment) throws Exception{
		String parnetId = "";
		
		if (StringUtils.isBlank(material.getState()) && material.getMaterialCode().indexOf(".") == -1){
			throw new RuntimeException("格式错误，物料至少要在分组下面");
		}
		
		WarMaterialExample materialExample = new WarMaterialExample();
		materialExample.createCriteria()
			.andMaterialCodeEqualTo(material.getMaterialCode());
		List<WarMaterial> warMaterials = materialMapper.selectByExample(materialExample);
		if (warMaterials != null && warMaterials.size() > 0){
			throw new RuntimeException(material.getMaterialCode() + "已存在");
		}
		
		
		if (material.getMaterialCode().indexOf(".") != -1){
			WarMaterialExample example = new WarMaterialExample();
			example.createCriteria()
				.andMaterialCodeEqualTo(material.getMaterialCode().substring(0, material.getMaterialCode().lastIndexOf(".")))
				.andStateEqualTo("closed");
			List<WarMaterial> materials = materialMapper.selectByExample(example);
			if (materials == null || materials.size() <= 0){
				throw new RuntimeException("上级分组" + material.getMaterialCode().substring(0, material.getMaterialCode().lastIndexOf(".")) + "不存在，请先创建");
			}else{
				parnetId = materials.get(0).getId();
			}
		}
		
		
		int i = 0;
		if(StringUtils.isNotBlank(material.getState()) && material.getState().equals("closed")){//物料上级的分组
			WarMaterial material2 = new WarMaterial();
			material2.setId(UUIDBuild.getUUID());
			material2.setMaterialCode(material.getMaterialCode());
			material2.setMaterialName(material.getMaterialName());
			material2.setState("closed");
			
			i = materialMapper.insert(material2);
		}else{//物料
			material.setState(null);
			material.setId(UUIDBuild.getUUID());
			i = materialMapper.insert(material);
			
			WarMaterialInventory materialInventory = new WarMaterialInventory();
			materialInventory.setId(UUIDBuild.getUUID());
			materialInventory.setExistingQuantity(new BigDecimal(0));
			materialInventory.setWarMaterialId(material.getId());
			
			materialInventoryMapper.insert(materialInventory);
			
			if (attachment.getSize() > 0){
				File file = new File(ResourcesUtil.getValue("fileRootPath", "path"), "/material");
				if (!file.exists()){
					file.mkdirs();
				}
				
				WarMaterialFile materialFile = new WarMaterialFile();
				materialFile.setId(UUIDBuild.getUUID());
				materialFile.setFileName(attachment.getOriginalFilename());
				String suffix = attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf("."), attachment.getOriginalFilename().length());
				materialFile.setFilePath(UUIDBuild.getUUID()+suffix);
				try{
					attachment.transferTo(new File(file, materialFile.getFilePath()));
				}catch (FileNotFoundException e){
					throw new RuntimeException(e);
				}
				materialFile.setWarMaterialId(material.getId());
				materialFileMapper.insert(materialFile);
			}
		}
		return parnetId;
	}

	@Override
	public WarMaterial findMaterialByIdForEdit(String id) {
		return materialMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WarMaterialFile findMaterialFileById(String id) {
		return materialFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public WarMaterialFile findMaterialFileByWarMaterialId(String id) {
		WarMaterialFileExample materialFileExample = new WarMaterialFileExample();
		materialFileExample.createCriteria().andWarMaterialIdEqualTo(id);
		List<WarMaterialFile> materialFiles = materialFileMapper.selectByExample(materialFileExample);
		if (materialFiles != null && materialFiles.size() > 0){
			return materialFiles.get(0);
		}
		return null;
	}

	@Override
	public String updateWarMaterial(WarMaterial material, MultipartFile attachment) throws Exception{
		String parnetId = "";
		
		if (StringUtils.isBlank(material.getState()) && material.getMaterialCode().indexOf(".") == -1){
			throw new RuntimeException("格式错误，物料至少要在分组下面");
		}
		
		WarMaterialExample materialExample = new WarMaterialExample();
		materialExample.createCriteria()
			.andMaterialCodeEqualTo(material.getMaterialCode())
			.andIdNotEqualTo(material.getId());
		List<WarMaterial> warMaterials = materialMapper.selectByExample(materialExample);
		if (warMaterials != null && warMaterials.size() > 0){
			throw new RuntimeException(material.getMaterialCode() + "已存在");
		}
		
		
		if (material.getMaterialCode().indexOf(".") != -1){
			WarMaterialExample example = new WarMaterialExample();
			example.createCriteria()
				.andMaterialCodeEqualTo(material.getMaterialCode().substring(0, material.getMaterialCode().lastIndexOf(".")))
				.andStateEqualTo("closed");
			List<WarMaterial> materials = materialMapper.selectByExample(example);
			if (materials == null || materials.size() <= 0){
				throw new RuntimeException("上级分组" + material.getMaterialCode().substring(0, material.getMaterialCode().lastIndexOf(".")) + "不存在，请先创建");
			}else{
				parnetId = materials.get(0).getId();
			}
		}
		
		
		
		int i = 0;
		if(StringUtils.isNotBlank(material.getState()) && material.getState().equals("closed")){
			//前端切换的时候，判断文件是否存在
			WarMaterial material2 = new WarMaterial();
			material2.setId(material.getId());
			material2.setMaterialCode(material.getMaterialCode());
			material2.setMaterialName(material.getMaterialName());
			material2.setState("closed");
			
			i = materialMapper.updateByPrimaryKey(material2);
			
		}else{
			material.setState(null);
			i = materialMapper.updateByPrimaryKey(material);
			
			if (attachment.getSize() > 0){
				WarMaterialFile originalMaterialFile = findMaterialFileByWarMaterialId(material.getId());
				if (originalMaterialFile != null){
					throw new RuntimeException("已存在附件，请先删除原附件，在上传新的附件");
				}
				
				File file = new File(ResourcesUtil.getValue("fileRootPath", "path"), "/material");
				if (!file.exists()){
					file.mkdirs();
				}
				
				WarMaterialFile materialFile = new WarMaterialFile();
				materialFile.setId(UUIDBuild.getUUID());
				materialFile.setFileName(attachment.getOriginalFilename());
				String suffix = attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf("."), attachment.getOriginalFilename().length());
				materialFile.setFilePath(UUIDBuild.getUUID()+suffix);
				try{
					attachment.transferTo(new File(file, materialFile.getFilePath()));
				}catch (FileNotFoundException e){
					throw new RuntimeException(e);
				}
				materialFile.setWarMaterialId(material.getId());
				materialFileMapper.insert(materialFile);
			}
		}
		return parnetId;
	}

	@Override
	public int deleteWarMaterialFileById(String id) {
		WarMaterialFile materialFile = materialFileMapper.selectByPrimaryKey(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material", materialFile.getFilePath());
		if (file.exists()){
			if(!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
		}
		return materialFileMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteWarMaterialById(String id) {
		WarMaterial material = materialMapper.selectByPrimaryKey(id);
		
		WarMaterialQueryVo materialQueryVo = new WarMaterialQueryVo();
		materialQueryVo.setMaterialCodeForExpand(material.getMaterialCode());
		materialQueryVo.setLevel(material.getMaterialCode().length() - material.getMaterialCode().replace(".", "").length() + 1);//根据含有多少个“.”，设置层级数
		
		String total = materialMapper.findAllWarMaterialTotal(materialQueryVo);
		
		System.out.println(total);
		
		if (Integer.parseInt(total) > 0){
			throw new RuntimeException("该分组下面有物料，不能删除");
		}
		
		WarMaterialInventoryExample materialInventoryExample = new WarMaterialInventoryExample();
		materialInventoryExample.createCriteria().andWarMaterialIdEqualTo(id);
		List<WarMaterialInventory> materialInventories = materialInventoryMapper.selectByExample(materialInventoryExample);
		if (materialInventories != null && materialInventories.size() > 0 && materialInventories.get(0).getExistingQuantity().compareTo(BigDecimal.ZERO) == 1){
			throw new RuntimeException("库存不为0，不能删除");
		}
		materialInventoryMapper.deleteByExample(materialInventoryExample);
		
		WarMaterialFileExample materialFileExample = new WarMaterialFileExample();
		materialFileExample.createCriteria().andWarMaterialIdEqualTo(id);
		List<WarMaterialFile> materialFiles = materialFileMapper.selectByExample(materialFileExample);
		if (materialFiles != null && materialFiles.size() > 0){
			WarMaterialFile materialFile = materialFiles.get(0);
			
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material", materialFile.getFilePath());
			if(!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
			materialFileMapper.deleteByPrimaryKey(materialFile.getId());
		}
		return materialMapper.deleteByPrimaryKey(id);
	}
}
