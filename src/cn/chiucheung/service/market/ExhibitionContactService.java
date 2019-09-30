package cn.chiucheung.service.market;

import java.util.List;

import cn.chiucheung.po.market.exhibitioncontact.MarExhibitionContact;
import cn.chiucheung.pojo.market.exhibitioncontact.MarExhibitionContactQueryVo;

public interface ExhibitionContactService {
	
	/**
	 * 新增
	 * @param exhibitionContact
	 * @return
	 */
	int saveExhibitionContact(MarExhibitionContact exhibitionContact);

	List<MarExhibitionContact> findAllExhibitionContactList(MarExhibitionContactQueryVo exhibitionContactQueryVo);

	String findAllExhibitionContactTotal(MarExhibitionContactQueryVo exhibitionContactQueryVo);

}
