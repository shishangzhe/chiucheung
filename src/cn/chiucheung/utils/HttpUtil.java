package cn.chiucheung.utils;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

import org.springframework.web.context.ContextLoader;

public class HttpUtil{
	private static Map<String, String> errorMap = new HashMap<String, String>();
	static{
		errorMap.put("emptyFullPath", "空白的路径");
		errorMap.put("wrongAuth", "错误的用户名或密码");
		errorMap.put("systemSyncDisabled", "E6服务器未开启同步功能");
		errorMap.put("userSyncDisabled", "用户未开启同步功能");
		errorMap.put("folderNotFound", "没有权限");
		errorMap.put("fileIsNull", "文件不存在");
		errorMap.put("docLengthZero", "文件尺寸为0");
		errorMap.put("noPermission", "没有权限");
		errorMap.put("emptyFilename", "空白的文件名");
		errorMap.put("fileAmountExceeded", "文件数量超过限制");
		errorMap.put("serverDocumentNotFound", "找不到对应服务器文档");
		errorMap.put("equalHash", "相同的文件指纹");
		errorMap.put("documentLocked", "文档已锁定");
		errorMap.put("isEditing", "文档正在编辑中");
		errorMap.put("isOnWorkflow", "文档正在审批中");
		errorMap.put("exception", "保存文件时出现异常");
		errorMap.put("emptyTicket", "令牌为空");
		errorMap.put("userNotExists", "用户不存在");
		errorMap.put("userNotExistsOrWrongPassword", "用户不存在或密码错误");
		errorMap.put("userDisabled", "用户已经被禁止登录");
		errorMap.put("wrongIp", "错误的IP，用户已经设置了登录IP限制");
		errorMap.put("userInvalid", "用户异常");
		errorMap.put("noMobileAccess", "无通过移动访问系统的权限");
		errorMap.put("folderExists", "同名目录已存在");
		errorMap.put("noPermissionOrNotExists", "对象不存在或没有对应权限");
		errorMap.put("subFolderExists", "当前目录有子目录存在");
		errorMap.put("filesInFolder", "当前目录内有文档存在");
		errorMap.put("tooLargePageSize", "过大的单页记录数");
		errorMap.put("emptyPassword", "未输入密码");
		errorMap.put("emptyUsername", "未输入用户名");
		errorMap.put("emptyFullname", "未输入全名");
		errorMap.put("emptyGroupIds", "未输入部门ID");
		errorMap.put("notStrongPassword", "不是强密码");
		errorMap.put("userExists", "同名用户已存在");
		errorMap.put("userAmountExceeded", "用户数已超过授权数");
		errorMap.put("canNotDeleteAdmin", "不能删除系统管理员");
		errorMap.put("invalidName", "错误的名称");
		errorMap.put("fileExistsAndNotEqualHash", "同名文件已存在但内容不同，冲突");
		errorMap.put("dataNotExists", "指定数据不存在");
		errorMap.put("dataExists", "数据已存在");
		errorMap.put("taskCompleted", "任务已完成");
		errorMap.put("emptyAssignees", "空白的任务候选人");
		errorMap.put("emptyComment", "空白的说明");
		errorMap.put("processEnded", "流程已完结");
		errorMap.put("dataTooLong", "数据过长");
		errorMap.put("reachedMaxLoginError", "达到最大登录错误次数限制");
		errorMap.put("notWithdrawable", "下一节点的人员已经办理本流程，无法收回");

	}
   
    public static String getJsonContent(String urlStr){
    	String str = new String();
        try{// 获取HttpURLConnection连接对象
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            // 设置连接属性

            httpConn.setReadTimeout(3000);//设置从主机读取数据超时
            httpConn.setConnectTimeout(3000);//设置连接主机超时
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // 获取相应码
            int respCode = httpConn.getResponseCode();
            if (respCode == 200){
            	str = ConvertStream2Json(httpConn.getInputStream());
            }
        }
        catch (MalformedURLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SocketTimeoutException e){
        	str = "连接超时";////用于判断连接超时
        }
        catch (IOException e){
            // TODO Auto-generated catch block
        	str = "获取数据失败";
        }
		return str;
    }

   
    private static String ConvertStream2Json(InputStream inputStream){
        String jsonStr = "";
        try {
			/*BufferedReader in
			= new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			jsonStr=in.readLine();*/
        	byte[] bs =new byte[1024];
        	int i = 0;
        	while ((i = inputStream.read(bs)) != -1){
        		jsonStr = jsonStr + new String(bs,0,i,"utf-8");
        	}
		} catch (IOException e){
			e.printStackTrace();
		}
        return jsonStr;
    }
    
    //获取E6的ticket,如果获取失败，则抛出异常，异常的内容为错误的信息
    public static String getTicket(String username, String password){
		String url = ResourcesUtil.getValue("E6", "ticketUrl");
		String ticket = getJsonContent(url+"?username="+username+"&password="+password+"&validMin=30");
		if (ticket.contains("error")){
			throw new RuntimeException(errorMap.get(ticket.split(":")[1]));
		}
		return ticket;
    }
    
    //根据文件的sn从E6获取文件的信息
    public static JSONObject findDocInfoBySn(String sn, String username, String password){
    	JSONObject jsonObj = new JSONObject();
    	String url = ResourcesUtil.getValue("E6", "fileInfoUrl");
		String ticket = getTicket(username, password);
		String fileInfo = getJsonContent(url + "?ticket="+ticket+"&sn="+sn);
		fileInfo = fileInfo.trim();
		fileInfo = fileInfo.replace("null", "\"\"");
		jsonObj = JSONObject.fromObject(fileInfo);
		String reason = errorMap.get(jsonObj.get("reason"));
		jsonObj.put("reason", reason);
		return jsonObj;
    }
    
  //根据文件的id从E6获取文件的信息
    public static JSONObject findDocInfoByDocId(String docId, String ticket){
    	JSONObject jsonObj = new JSONObject();
    	String url = ResourcesUtil.getValue("E6", "fileInfoUrl");
		String fileInfo = getJsonContent(url + "?ticket="+ticket+"&id="+docId);
		fileInfo = fileInfo.trim();
		fileInfo = fileInfo.replace("null", "\"\"");
		jsonObj = JSONObject.fromObject(fileInfo);
		jsonObj.put("reason", errorMap.get(jsonObj.get("reason")));
		return jsonObj;
    }
    
    //根据url获取inputStream流
    public static InputStream getInputStream(String urlStr){
    	InputStream inputStream = null;
        // 获取HttpURLConnection连接对象
        try {
			URL url = new URL(urlStr);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 设置连接属性

			httpConn.setReadTimeout(3000);//设置从主机读取数据超时
			httpConn.setConnectTimeout(3000);//设置连接主机超时
			httpConn.setDoInput(true);
			httpConn.setRequestMethod("GET");
			// 获取相应码
			int respCode = httpConn.getResponseCode();
			if (respCode == 200){
				inputStream = httpConn.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
       
		return inputStream;
    }
}
