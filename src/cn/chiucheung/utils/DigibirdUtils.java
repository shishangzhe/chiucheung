package cn.chiucheung.utils;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DigibirdUtils {

	private static Logger logger = LoggerFactory.getLogger(DigibirdUtils.class);
	private static RequestConfig requestConfig = null;

	static {
		// 设置请求和传输超时时间
		requestConfig = RequestConfig.custom().setSocketTimeout(8000)
				.setConnectTimeout(8000).build();
	}
	

	// 获取席位信息
	public static String getSeat() {
		String url = "http://localhost:8080/darwin/service/open-api/unis/login";
		return httpGet(url);
	}

	// 获取用户信息
	public static String getUser() {
		String url = "http://localhost:8080/darwin/service/open-api/unis/userList";
		return httpGet(url);
	}

	public static String getOtherInfo() {
		String url = "http://localhost:8080/darwin/service/open-api/unis/user-seat-device";
		return httpGet(url);
	}

	public static String getEquipmentHardware() {
		String url = "http://localhost:8080/darwin/service/open-api/unis/hardware";
		return httpGet(url);
	}

	public static String getLogin(String userId, String seatId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", userId);
		jsonObject.put("seatId", seatId);
		String url = "http://localhost:8080/darwin/service/open-api/unis/login";
		return httpPost(url, jsonObject);
	}

	public static String getOutLogin(String userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", userId);
		String url = "http://localhost:8080/darwin/service/open-api/unis/logout";
		return httpPost(url, jsonObject);
	}

	/**
	 * @param url
	 *            url地址
	 * @param strParam
	 *            参数
	 * @return
	 */
	public static String httpPost(String url, JSONObject strParam) {

		String jsonResult = null;
		HttpPost httpPost = null;
		try {
			//创建httpClient对象
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//创建httpPost对象
			httpPost = new HttpPost(url);
			//设置响应时间
			httpPost.setConfig(requestConfig);
			//设置头文件
			httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
			
			if (null != strParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(strParam.toString(),"utf-8");
				entity.setContentEncoding("UTF-8");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			try {
				// 读取服务器返回过来的json字符串数据
				jsonResult = EntityUtils.toString(result.getEntity(), "utf-8");
			} catch (Exception e) {
				logger.info("errMessage", "post请求提交失败:" + url + ":" + e);
			}

		} catch (IOException e) {
			logger.info("errMessage", "post请求提交失败:" + url + ":" + e);
		} finally {
			httpPost.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static String httpGet(String url) {
		// get请求返回结果
		String jsonResult = null;
		HttpGet httpGet = null;
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			// 发送get请求
			httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = client.execute(httpGet);
			// 读取服务器返回过来的json字符串数据
			HttpEntity entity = response.getEntity();
			jsonResult = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			logger.info("errMessage", "post请求提交失败:" + url + ":" + e);
		} finally {
			httpGet.releaseConnection();
		}
		return jsonResult;
	}

	public static void main(String[] args) {
		getOutLogin("10");
	}

}
