package cn.chiucheung.dao.mapper.finance.planetrainticket;

import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicket;
import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicketExample;
import cn.chiucheung.pojo.finance.planetrainticket.FinPlaneTrainTicketQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FinPlaneTrainTicketMapper {
    int countByExample(FinPlaneTrainTicketExample example);

    int deleteByExample(FinPlaneTrainTicketExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinPlaneTrainTicket record);

    int insertSelective(FinPlaneTrainTicket record);

    List<FinPlaneTrainTicket> selectByExample(FinPlaneTrainTicketExample example);

    FinPlaneTrainTicket selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinPlaneTrainTicket record, @Param("example") FinPlaneTrainTicketExample example);

    int updateByExample(@Param("record") FinPlaneTrainTicket record, @Param("example") FinPlaneTrainTicketExample example);

    int updateByPrimaryKeySelective(FinPlaneTrainTicket record);

    int updateByPrimaryKey(FinPlaneTrainTicket record);

	List<FinPlaneTrainTicket> findAllPlaneTrainTicketList(FinPlaneTrainTicketQueryVo trainTicketQueryVo);

	String findAllPlaneTrainTicketTotal(FinPlaneTrainTicketQueryVo trainTicketQueryVo);

	int insertList(List<FinPlaneTrainTicket> planeTrainTickets);

	int updatePlaneTrainTicketByIdForLock(FinPlaneTrainTicket planeTrainTicket);

	int updatePlaneTrainTicketByIdForReceiveReceipt(FinPlaneTrainTicket planeTrainTicket);
}