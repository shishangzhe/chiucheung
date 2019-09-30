package cn.chiucheung.service.finance;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicket;
import cn.chiucheung.pojo.finance.planetrainticket.FinPlaneTrainTicketQueryVo;

public interface PlaneTrainTicketService {
	
	/**
	 * 查找所有的planeTrainTicket
	 * @param planeTrainTicketQueryVo 查询条件
	 * @return
	 */
	List<FinPlaneTrainTicket> findAllPlaneTrainTicketList(FinPlaneTrainTicketQueryVo planeTrainTicketQueryVo);
	
	/**
	 * 查询所有的planeTrainTicket的总数
	 * @param planeTrainTicketQueryVo
	 * @return
	 */
	String findAllPlaneTrainTicketTotal(FinPlaneTrainTicketQueryVo planeTrainTicketQueryVo);
	
	/**
	 * 新增planeTrainTicket
	 * @param planeTrainTicket
	 * @return
	 */
	int savePlaneTrainTicket(FinPlaneTrainTicket planeTrainTicket);
	
	/**
	 * 根据id查找planeTrainTicket,用于页面的编辑
	 * @param id
	 * @return
	 */
	FinPlaneTrainTicket findPlaneTrainTicketById(String id);
	
	/**
	 * 更新planeTrainTicket
	 * @param planeTrainTicket
	 * @return
	 */
	int updatePlaneTrainTicket(FinPlaneTrainTicket trainTicket);
	
	/**
	 * 根据di删除planeTrainTicket
	 * @param id
	 * @return
	 */
	int deletePlaneTrainTicketById(String id);
	
	/**
	 * 设置是否已报账
	 * @param planeTrainTicket
	 * @return
	 */
	int updatePlaneTrainTicketByIdForLock(FinPlaneTrainTicket planeTrainTicket);
	
	/**
	 * 设置是否已收回票据
	 * @param planeTrainTicket
	 * @return
	 */
	int updatePlaneTrainTicketByIdForReceiveReceipt(FinPlaneTrainTicket planeTrainTicket);
	
	/**
	 * 导入Excel
	 * @param uploadFile
	 * @return
	 */
	int insertListForImportExcel(MultipartFile uploadFile) throws Exception;
	
	/**
	 * 根据id查找planeTrainTicket,用于页面的复制
	 * @param id
	 * @return
	 */
	FinPlaneTrainTicket copyPlaneTrainTicketById(String id);

}
