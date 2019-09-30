package cn.chiucheung.pojo.finance.workcardinfo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.utils.UserUtils;

public class FinWorkCardInfoQueryVo {
	private SysUser user;
	
	private List<Privilege> privileges;
	
	private boolean isShowContractAmount;
	
	private boolean isShowExpectedInstallationCost;
	
	private String id;
	
	private String workCardNo;
	
	private String projectLeader;
	
	private Date startTime;
	
	private Date endTime;
	
	private String groupsId;//用于导出分组
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;
	
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
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(String groupsId) {
		this.groupsId = groupsId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStartPage() {
		return (page-1)*rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}
