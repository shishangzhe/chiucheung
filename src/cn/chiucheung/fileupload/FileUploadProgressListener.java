package cn.chiucheung.fileupload;

import javax.servlet.http.HttpSession; 
import org.apache.commons.fileupload.ProgressListener; 
import org.springframework.stereotype.Component; 
  
@Component("progressListener")
public class FileUploadProgressListener implements ProgressListener { 
  private HttpSession session; 
  public void setSession(HttpSession session){ 
    this.session=session; 
    Progress status = new Progress();//保存上传状态 
    session.setAttribute("status", status); 
  } 
  public void update(long pBytesRead, long pContentLength, int pItems) { 
    Progress status = (Progress) session.getAttribute("status"); 
    /*try { 
      Thread.sleep(5); 
    } catch (InterruptedException e) { 
      e.printStackTrace(); 
    }*/
    status.setpBytesRead(pBytesRead); 
    status.setpContentLength(pContentLength); 
    status.setpItems(pItems); 
    /*System.out.println(">>>>>>>>>>>>>>>>>>>>"+status); */
  } 
} 
