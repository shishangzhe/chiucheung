package cn.chiucheung.service.market;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.pojo.market.conductpropagandafile.MarConductPropagandaFileQueryVo;

public interface ConductPropagandaFileService {
	/**
	 * 查询所有的宣传文件
	 * @param conductPropagandaFileQueryVo
	 * @return
	 */
	List<MarConductPropagandaFile> findAllConductPropagandaFile(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo);
	
	/**
	 * 查询所有的宣传文件的总数量
	 * @param conductPropagandaFileQueryVo
	 * @return
	 */
	String findAllConductPropagandaFileTotal(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo);
	
	/**
	 * 根据新版本的文件，查找老版本的文件
	 * @param id
	 * @return
	 */
	List<MarConductPropagandaFile> findAllOldConductPropagandaFileByNewId(String id);
	
	/**
	 * 新增宣传文件
	 * @param file
	 * @return
	 */
	int saveConductPropagandaFile(MultipartFile file) throws Exception;
	
	
	List<MarConductPropagandaFile> checkFileNameIsRepeat(String fileName);
	
	/**
	 * 更新宣传文件，不是在原基础上更新，而且文件名相同，版本号更新，文件更新
	 * @param fileName
	 * @param file
	 * @return
	 */
	int updateConductPropagandaFile(String fileName, MultipartFile file) throws Exception;
	
	/**
	 * 删除宣传文件
	 * @param id
	 * @return
	 */
	int deleteConductPropagandaFileById(String id) throws Exception;
	
	/**
	 * 根据id查找宣传文件，用于下载
	 * @param id
	 * @return
	 */
	MarConductPropagandaFile findConductPropagandaFileById(String id);
	
	/**
	 * 根据文件名查找最大的版本号
	 * @param fileName
	 * @return
	 */
	List<MarConductPropagandaFile> findMaxVersionFormConductPropagandaFileByFileName(String fileName);
	
	/**
	 * 获取宣传文件的列表，给saleApp用
	 * @return
	 */
	List<MarConductPropagandaFile> findConductPropagandaFileList();
}
