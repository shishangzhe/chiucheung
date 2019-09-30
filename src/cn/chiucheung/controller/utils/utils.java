package cn.chiucheung.controller.utils;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.utils.ImageUtil;


@Controller
@RequestMapping("/utils")
public class utils {
	
	/**
	 * 主页的跳转
	 * @return 跳转的页面
	 */
	@RequestMapping("index")
	public String index(){
		return "utils";
	}
	
	/**
	 * 根据导入Excel的电话号码查询归属地，填入Excel在导出
	 * @param attachment
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("phoneNoClassified")
	public String phoneNoClassified(MultipartFile attachment, HttpServletRequest request, HttpServletResponse response){
		try {
			POIFSFileSystem pfs = new POIFSFileSystem(attachment.getInputStream());
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			int lastRowNum = sheet.getLastRowNum();
			Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
			for (int i = 1; i < lastRowNum; i++) {
				HSSFRow hssfRow = sheet.getRow(i);
				Cell cell = hssfRow.getCell(11);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
				String phoneNo = cell.getStringCellValue();
				phoneNo = phoneNo.trim();
				String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + phoneNo;
				String text = getJsonContent(url,null);
				String province = null;
				if (text.contains("__GetZoneResult_ = ")){
					text = text.split("__GetZoneResult_ = ")[1];
					JSONObject jsonObject = JSONObject.fromObject(text);
					if (jsonObject.containsKey("province")){
						province = jsonObject.getString("province");
					}else{
						province = "unknow";
					}
				}else{
					province = "unknow";
				}
				if (map.containsKey(province)){
					List<List<String>> lists = map.get(province);
					List<String> list = new ArrayList<String>();
					int physicalNumberOfCells = hssfRow.getPhysicalNumberOfCells();
					for (int j = 0; j < physicalNumberOfCells; j++) {
						Cell cells = hssfRow.getCell(j);
						if (cells != null){
							cells.setCellType(HSSFCell.CELL_TYPE_STRING);
							list.add(cells.getStringCellValue());
						}
					}
					lists.add(list);
				}else{
					List<List<String>> lists = new ArrayList<List<String>>();
					List<String> list = new ArrayList<String>();
					int physicalNumberOfCells = hssfRow.getPhysicalNumberOfCells();
					for (int j = 0; j < physicalNumberOfCells; j++) {
						Cell cells = hssfRow.getCell(j);
						if (cells != null){
							cells.setCellType(HSSFCell.CELL_TYPE_STRING);
							list.add(cells.getStringCellValue());
						}
					}
					lists.add(list);
					map.put(province, lists);
				}
			}
			//创建HSSFWorkbook对象  
			HSSFWorkbook wb2 = new HSSFWorkbook();  
			//创建HSSFSheet对象  
			HSSFSheet sheet2 = wb2.createSheet("sheet0");
			HSSFRow headerRow = sheet.getRow(0);
			int physicalNumberOfCells = headerRow.getPhysicalNumberOfCells();
			HSSFRow headerRow2 = sheet2.createRow(0);
			for (int i = 1; i < physicalNumberOfCells; i++) {
				HSSFCell cell = headerRow.getCell(i);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				String headerName = cell.getStringCellValue();
				headerRow2.createCell(i).setCellValue(headerName);
			}
			int i = 1;
			for (Map.Entry<String, List<List<String>>> entry : map.entrySet()) {
				String province = entry.getKey();
				List<List<String>> lists = entry.getValue();
				HSSFRow row = sheet2.createRow(i);
				row.createCell(0).setCellValue(province);
				i++;
				for (int j = 0; j < lists.size(); j++) {
					List<String> list = lists.get(j);
					HSSFRow row2 = sheet2.createRow(i);
					for (int k = 0; k < list.size(); k++) {
						row2.createCell(k).setCellValue(list.get(k));
					}
					i++;
				}
			}
			String filename = attachment.getOriginalFilename().substring(0, attachment.getOriginalFilename().lastIndexOf("."))+"_整理后.xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			response.setContentType("application/msexcel");   
			
			wb2.write(response.getOutputStream());
			

			//创建HSSFWorkbook对象  
			//输出Excel文件  
			wb.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			try {
				response.getWriter().write(e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public static String getJsonContent(String urlStr, String charset){
    	String str = new String();
        try{// 获取HttpURLConnection连接对象
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            // 设置连接属性

            httpConn.setReadTimeout(30000);//设置从主机读取数据超时
            httpConn.setConnectTimeout(30000);//设置连接主机超时
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // 获取相应码
            int respCode = httpConn.getResponseCode();
            if (respCode == 200){
            	byte[] bs =new byte[1024];
            	int i = 0;
            	while ((i = httpConn.getInputStream().read(bs)) != -1){
            		if (StringUtils.isNotBlank(charset)){
            			str = str + new String(bs,0,i,"UTF-8");
            		}else{
            			str = str + new String(bs,0,i);
            		}
            	}
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (SocketTimeoutException e){
        	str = "连接超时";////用于判断连接超时
        }
        catch (IOException e){
        	str = "获取数据失败";
        }
		return str;
    }
	
	
	@RequestMapping("markImage")
	public String markImage(@RequestParam MultipartFile[] images, HttpServletRequest request, HttpServletResponse response){
		try {
			File icon = new File(request.getSession().getServletContext().getRealPath("markImage"), "水印.png");
			Image ic = ImageIO.read(new FileInputStream(icon));
			// icon高度
			int icheight = ic.getHeight(null);
			// icon宽度
			int icwidth = ic.getWidth(null);
			
			String filename = "水印.zip";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			response.setContentType("application/zip");   
			
			OutputStream ops = response.getOutputStream();
			
			ZipOutputStream zos = new ZipOutputStream(ops);
			
			for (MultipartFile image : images) {
				Image img = ImageIO.read(image.getInputStream());
				// icon高度
				int height = img.getHeight(null);
				// icon宽度
				int width = img.getWidth(null);
				
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				// 创建一个指定 BufferedImage 的 Graphics2D 对象
				Graphics2D g = bi.createGraphics();
				
				double bili;
				//要考虑水印图片是否大于原图片，如果是，则需要缩放水印
				if (icwidth > width){
					bili = width / (double)icwidth;
					icwidth = width;
					icheight = (int) (icheight * bili);
				}
				if (icheight > height){
					bili = height / (double)icheight;
					icheight = height;
					icwidth = (int) (icwidth * bili);
				}
				// x,y轴默认是从0坐标开始
				int x = (width / 2) - (icwidth / 2);
				int y = (height / 2) - (icheight / 2);
				
				// 设置对线段的锯齿状边缘处理
				g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				// 呈现一个图像，在绘制前进行从图像空间到用户空间的转换
				g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
				
				// 透明度，最小值为0，最大值为1
				float clarity = 0.6f;
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));
				// 表示水印图片的坐标位置(x,y)
				g.drawImage(ic, x, y, icwidth, icheight, null);
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
				g.dispose();
				
				zos.putNextEntry(new ZipEntry(image.getOriginalFilename()));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				ImageIO.write(bi, image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1), baos);
				zos.write(baos.toByteArray());//第一次写入就开始下载，所以下载会比较慢
			}
			
			
			zos.flush();
			zos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("getProvinceByCity")
	public String getProvinceByCity(){
		File file = new File("d:/11.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null;
			while((str = br.readLine()) != null){
				String url = "https://api.shenjian.io/?appid=bf11575124a00e244b802c547cb23041&city=" + URLEncoder.encode(str,"UTF-8" );
				String text = getJsonContent(url, "UTF-8");
				System.out.println(text);
				JSONObject jsonObject = JSONObject.fromObject(text);
				String province;
				if (jsonObject.getString("error_code").equals("0")){
					province = jsonObject.getJSONObject("data").getString("province");
				}else{
					province = "";
				}
				System.out.println(str + ":" + province);
				Thread.sleep(5000);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}
}
