package cn.chiucheung.service.sales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.sales.projectinfo.SalProjectInfo;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPic;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoCustom;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;

public interface ProjectInfoService {
	
	/**
	 * 查询所有的项目信息
	 * @param projectInfoQueryVo 查询条件
	 * @return
	 */
	List<SalProjectInfoCustom> findAllProjectInfoList(SalProjectInfoQueryVo projectInfoQueryVo);
	
	/**
	 * 查询所有项目信息的总数
	 * @param projectInfoQueryVo 查询条件
	 * @return
	 */
	String findAllProjectInfoTotal(SalProjectInfoQueryVo projectInfoQueryVo);
	
	/**
	 * 新增项目信息
	 * @param projectInfo
	 * @param pic 上传的文件
	 * @return
	 */
	int saveSalProjectInfo(SalProjectInfo projectInfo, MultipartFile[] pic) throws Exception;
	
	/**
	 * 根据id查找项目信息
	 * @param id
	 * @return
	 */
	SalProjectInfoCustom findSalProjectInfoById(String id) throws Exception;
	
	/**
	 * 更新项目信息
	 * @param request 
	 * @param projectInfo
	 * @param pic 
	 * @return
	 */
	int updateSalProjectInfo(SalProjectInfo projectInfo, MultipartFile[] pic) throws Exception;
	
	/**
	 * 根据id删除项目信息
	 * @param id
	 * @return
	 */
	int deleteSalProjectInfoById(String id);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	SalProjectInfoPic findSalProjectInfoPicById(String id);
	
	/**
	 * 根据id删除项目信息图片,该实现方法可能存在文件删除失败的问题
	 * @param id
	 * @return
	 */
	int deleteSalProjectInfoPicById(String id) throws Exception;
	
	/**
	 * 导入Excel
	 * @param excel
	 * @return
	 * @throws Exception
	 */
	int insertListForImportExcel(MultipartFile excel) throws Exception;

	/**
	 * 查询所有的项目信息，用于导出Excel
	 * @return
	 */
	List<SalProjectInfo> findAllProjectInfoListForExport();

	/**
	 * 根据工咭号查找项目信息，用于图片导入
	 * @param name
	 * @return
	 */
	int insertPicByDirectory() throws Exception;

}
