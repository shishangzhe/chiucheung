package cn.chiucheung.service.market.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.market.exhibitioncontact.MarExhibitionContactMapper;
import cn.chiucheung.po.market.exhibitioncontact.MarExhibitionContact;
import cn.chiucheung.pojo.market.exhibitioncontact.MarExhibitionContactQueryVo;
import cn.chiucheung.service.market.ExhibitionContactService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class ExhibitionContactServiceImpl implements ExhibitionContactService {
	
	@Autowired MarExhibitionContactMapper exhibitionContactMapper;
	
	@Override
	public int saveExhibitionContact(MarExhibitionContact exhibitionContact) {
		exhibitionContact.setId(UUIDBuild.getUUID());
		exhibitionContact.setSignUpTime(new Date());
		return exhibitionContactMapper.insert(exhibitionContact);
	}

	@Override
	public List<MarExhibitionContact> findAllExhibitionContactList(MarExhibitionContactQueryVo exhibitionContactQueryVo) {
		return exhibitionContactMapper.findAllExhibitionContactList(exhibitionContactQueryVo);
	}

	@Override
	public String findAllExhibitionContactTotal(MarExhibitionContactQueryVo exhibitionContactQueryVo) {
		return exhibitionContactMapper.findAllExhibitionContactTotal(exhibitionContactQueryVo);
	}

}
