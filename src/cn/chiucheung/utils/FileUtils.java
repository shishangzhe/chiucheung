package cn.chiucheung.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 用于项目信息评审的文件上传及返回文件上传后的路径
 * @author adm-03
 *
 */
public class FileUtils {
	/**
	 * 将spingmvc接收到的文件存到/WEB-INF/uploads/模块文件夹/日期的文件夹/uuid文件名的文件
	 * @param multipartFile springmvc接收到的文件
	 * @param model 模块的名称
	 * @param request
	 * @return
	 */
	public static String getFileUploadPath(MultipartFile multipartFile, String model) {
		//以下被注的是返回的绝对路径，当项目被移植时，会出现问题
		String basePath = "/uploads/";
		String datePath = getDatePath(new Date());
		String path = basePath + model + datePath;
		File file = new File(new File(FileUtils.class.getClassLoader().getResource("").getPath()).getParent(), path);
		if (!file.exists()){
			file.mkdirs();
		}
		String uploadsFileName = multipartFile.getOriginalFilename();
		String prex = uploadsFileName.substring(uploadsFileName.lastIndexOf("."));
		uploadsFileName = UUIDBuild.getUUID() + prex;
		File destFile = new File(file,uploadsFileName);
		try {
			multipartFile.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path+"/"+uploadsFileName;
	}
	
	/**
	 * 根据日期获取路径
	 * @param date
	 * @return
	 */
	public static String getDatePath(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("/yyyy/MM/dd/");
		return format.format(date);
	}

    /**
     * 下载文件
     * @param response 响应
     * @param file 需下载的文件
     */
    public static void downloadFile(HttpServletResponse response, File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(b)) != -1) {
                response.getOutputStream().write(b, 0, i);
            }
        } catch (FileNotFoundException e) {
            try {
                response.getWriter().write("file not found");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if (inputStream != null){
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                inputStream = null;
            }
        }
    }

}
