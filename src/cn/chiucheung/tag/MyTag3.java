package cn.chiucheung.tag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag3 extends SimpleTagSupport{
	private int times;
	
	private String year;
	
	public void setTimes(int times) {
		this.times = times;
	}

	public void setYear(String year) {
		this.year = year;
	}


	@Override
	public void doTag() throws JspException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		String year = date.substring(2, 4);
		for (int i=0;i<times;i++){
			this.getJspContext().setAttribute("year", Integer.parseInt(year)-i); 
			getJspBody().invoke(null);
		}
	}
}
