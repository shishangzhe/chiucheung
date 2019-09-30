package cn.chiucheung.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageUtil {


    public static String DEFAULT_PREVFIX = "thumb_";
    public static Boolean DEFAULT_FORCE = false;//建议该值为false

    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 根据图片路径生成缩略图 </p>
     * @param imagePath    原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     * @param thumbnailImagePath    生成缩略图的路径
     * @param force        是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     */
    public static void thumbnailImage(String imagePath, int w, int h, String thumbnailImagePath, boolean force) throws Exception{
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
            String types = Arrays.toString(ImageIO.getReaderFormatNames());
            String suffix = null;
            // 获取图片后缀
            if(imgFile.getName().indexOf(".") > -1) {
                suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
            }// 类型和图片后缀全部小写，然后判断后缀是否合法
            if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                throw new RuntimeException("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
            }
            Image img = ImageIO.read(imgFile);
            if(!force){
                // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                int width = img.getWidth(null);
                int height = img.getHeight(null);
                if((width*1.0)/w < (height*1.0)/h){
                    if(width > w){
                        h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                    }
                } else {
                    if(height > h){
                        w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                    }
                }
            }
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
            g.dispose();
            // 将图片保存在原目录并加上前缀
            ImageIO.write(bi, suffix, new File(thumbnailImagePath));
        }else{
        	throw new RuntimeException("the image is not exist.");
        }
    }
    
    /**
     * 缩放成指定高
     * @param imagePath
     * @param h
     * @param thumbnailImagePath
     * @throws Exception
     */
    public static void thumbnailImage(String imagePath, int h, String thumbnailImagePath) throws Exception{
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
            String types = Arrays.toString(ImageIO.getReaderFormatNames());
            String suffix = null;
            // 获取图片后缀
            if(imgFile.getName().indexOf(".") > -1) {
                suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
            }// 类型和图片后缀全部小写，然后判断后缀是否合法
            if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                throw new RuntimeException("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
            }
            Image img = ImageIO.read(imgFile);
            // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
            int width = img.getWidth(null);
            int height = img.getHeight(null);
            int w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
            g.dispose();
            // 将图片保存在原目录并加上前缀
            ImageIO.write(bi, suffix, new File(thumbnailImagePath));
        }else{
        	throw new RuntimeException("the image is not exist.");
        }
    }

    public static void main(String[] args) {
        try {
			new ImageUtil().thumbnailImage("C:/Users/adm-03/Desktop/微信图片_20180607174411.jpg", 300, 300,"C:/Users/adm-03/Desktop/thumbnail/微信图片_20180607174411.jpg",DEFAULT_FORCE);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
