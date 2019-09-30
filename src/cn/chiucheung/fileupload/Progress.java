package cn.chiucheung.fileupload;

public class Progress { 
    
	private long pBytesRead;//已经上传大小
	
	private long pContentLength;//总大小
	
	private long pItems;
	
	public long getpBytesRead() { 
		return pBytesRead; 
	}
	
	public void setpBytesRead(long pBytesRead) { 
		this.pBytesRead = pBytesRead; 
	}
	
	public long getpContentLength() { 
		return pContentLength; 
	}
	
	public void setpContentLength(long pContentLength) { 
		this.pContentLength = pContentLength; 
	}
	
	public long getpItems() { 
		return pItems; 
	}
	
	public void setpItems(long pItems) { 
		this.pItems = pItems; 
	}
	
	@Override
	public String toString() { 
		return "Progress [pBytesRead=" + pBytesRead + ", pContentLength="
		+ pContentLength + ", pItems=" + pItems + "]"; 
	}   
} 

