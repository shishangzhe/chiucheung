package cn.chiucheung.pojo.finance.workcardinfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.utils.UserUtils;

public class FinWorkCardInfoForUpdateCustom extends FinWorkCardInfo{
	private SysUser user;
	
	private List<Privilege> privileges;
	
	private boolean isShowContractAmount;
	
	private boolean isShowExpectedInstallationCost;
	
	private boolean isEditWorkCardNo;
	
	private boolean isEditProjectLeader;
	
	private boolean isEditExpectedInstallationTime;
	
	private boolean isEditActualAuxiliaryTime;
	
	private boolean isEditCompletionDate;
	
	public void setSession(HttpSession session){
		user = UserUtils.getUserFromSession(session);
		privileges = (List<Privilege>) session.getAttribute("privileges");
	}

	public boolean getIsShowContractAmount() {
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gkz");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}

	public boolean getIsShowExpectedInstallationCost(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gky");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getIsEditWorkCardNo(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gkt");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getIsEditProjectLeader(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gku");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getIsEditExpectedInstallationTime(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gkv");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}

	public boolean getIsEditActualAuxiliaryTime(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gkw");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}

	public boolean getIsEditCompletionDate(){
		Privilege privilege = new Privilege();
		privilege.setPid("gk");
		privilege.setMid("gkx");
		if (user.getLoginName().equals("admin")){
			return true;
		}else if (privileges.contains(privilege)){
			return true;
		}else{
			return false;
		}
	}
}
