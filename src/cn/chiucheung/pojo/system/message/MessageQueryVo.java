package cn.chiucheung.pojo.system.message;


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class MessageQueryVo {
	private String loginName;
	
	private String keyword;//查询条件
    //每页的记录数
    private int pageSize = 10;
    //当前页
    private int pageNo;
    //开始记录数
    private int beginResult = 0;
    //总记录数
    private int totalResult = 0;
    //总页数
    private int totalPage = 0;
    
    private MessagePageBean page=null;
    
    /**
     * 计算总页数
     */
    private void countPages() {
        if(totalResult==0) {
            this.totalPage=1;
        }
        else {
            this.totalPage = (totalResult / pageSize); //总共几页
            if ((totalResult % pageSize) != 0) this.totalPage = this.totalPage + 1;
        }
    }

    public boolean isFirstPage(){
    	
    	if(this.pageNo<=1){
    		
    		return true;
    	}else
    	{
    		return false;	
    	}	
    }
    
    public boolean isLastPage(){
    	
    	if(this.pageNo>=this.totalPage){
    		
    		return true;
    	}else
    	{
    		return false;	
    	}	
    }
    
    /**
     * 获得当前页
     * @return int 当前页
     */
    public int getPageNo() {
          return pageNo;
    }

    /**
     * 获得每页的记录数
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 获得总记录数
     * @return int
     */
    public int getTotalResult() {
        return totalResult;
    }

    /**
     * 设置当前页
     * @param current int 当前页码
     */
    public void setPageNo(int pageNo) {
        this.pageNo  = pageNo;
    }

    /**
     * 设置每页的记录数
     * @param i int 记录数
     */
    public void setPageSize(int i) {
        this.pageSize = i;
    }

    /**
     * 获得开始记录数
     * @return int 开始记录数
     */
    public int getBeginResult() {
    	
        return (pageNo-1)*pageSize;
    }

    /**
     * @param i
     */
    public void setBeginResult(int i) {
        this.beginResult = i;
    }

    /**
     * 获得总页数
     * @return int 总页数
     */
    public int getTotalPage() {
        
    	//log.info("run here totalPage:"+totalPage);
        return totalPage;
        
    }

    /**
     * @param totalResult
     *            The totalResult to set. 设置该分页信息总共有多少条记录
     */
    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
        countPages();
    }

    /**
     * 设置序号
     */
    private void setRequestValue(){    	
    	page=new MessagePageBean();
    	page.setFirstPage(isFirstPage());
    	page.setLastPage(isLastPage()); 		
        page.setPageNo(pageNo);	
    	page.setPageSize(pageSize);
    	page.setSumPage(totalPage);
    	page.setTotalResult(totalResult);

    }
    public MessagePageBean getPageBean(){
    	setRequestValue(); 
		return page;
    	
    }
    public void setTotalPage(int totalPage){
    	
    	this.totalPage=totalPage;
    }

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
  
}
