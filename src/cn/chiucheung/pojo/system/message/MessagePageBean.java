package cn.chiucheung.pojo.system.message;


public class MessagePageBean {
	//当前页
	private int pageNo;
	//是否是首页
    private boolean firstPage;
    //是否是最后页
    private boolean lastPage;
    //总页数
    private int sumPage;
    //每页多少数据
    private int pageSize ;
    //总记录数
    private int totalResult ;
   
    public void setSumPage(int sumPage)
    {
    	this.sumPage=sumPage;
    }
    public int getSumPage()
    {
    	return sumPage;
    }
    public void setPageNo(int pageNo)
    {
    	this.pageNo=pageNo;
    
    	
    }
    public int getPageNo()
    {
    	return pageNo;
    }
    public void setFirstPage(boolean firstPage)
    {
    	this.firstPage=firstPage;
    	
    }
    public boolean getFirstPage()
    {
    	return firstPage;
    }
    public void setLastPage(boolean lastPage)
    {
    	this.lastPage=lastPage;
    }
    public boolean getLastPage()
    {
    	return lastPage;
    }
    /**
     * 获得每页的记录数
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * 设置每页的记录数
     * @param i int 记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
    
    
}
