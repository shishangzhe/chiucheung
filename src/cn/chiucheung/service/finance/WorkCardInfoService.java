package cn.chiucheung.service.finance;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.controller.finance.FinWorkCardInfoAction;
import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForUpdateCustom;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForGenerateExcel;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoQueryVo;

public interface WorkCardInfoService {
	
	/**
	 * 查找所有的工咭信息
	 * @param workCardInfoQueryVo 查询条件
	 * @return
	 */
	List<FinWorkCardInfoForUpdateCustom> findAllWorkCardInfoList(FinWorkCardInfoQueryVo workCardInfoQueryVo);
	
	/**
	 * 查找所有的工咭信息的总记录数
	 * @param workCardInfoQueryVo
	 * @return
	 */
	String findAllWorkCardInfoTotal(FinWorkCardInfoQueryVo workCardInfoQueryVo);
	
	/**
	 * 新增工咭信息
	 * @param workCardInfo
	 * @return
	 */
	int saveWorkCardInfo(FinWorkCardInfo workCardInfo);
	
	/**
	 * 根据id查找工咭信息，用于页面的编辑
	 * @param id
	 * @return
	 */
	FinWorkCardInfo findWorkCardInfoById(FinWorkCardInfoQueryVo workCardInfoQueryVo);
	
	/**
	 * 更新工咭信息
	 * @param workCardInfoForUpdateCustom
	 * @return
	 */
	int updateWorkCardInfo(FinWorkCardInfoForUpdateCustom workCardInfoForUpdateCustom);
	
	/**
	 * 根据id删除工咭信息
	 * @param id
	 * @return
	 */
	int deleteWorkCardInfoById(String id);
	
	/**
	 * 查询所有完成工咭的各方面成本
	 * @param workCardInfoQueryVo 查询条件
	 * @return
	 */
	List<FinWorkCardInfoForGenerateExcel> FindAllCompletionWorkCardCostForGenerateExcel(FinWorkCardInfoQueryVo workCardInfoQueryVo);
	
	/**
	 * 导入Excel
	 * @param uploadFile
	 * @return
	 */
	int insertListForImportExcel(MultipartFile uploadFile) throws Exception;

}
