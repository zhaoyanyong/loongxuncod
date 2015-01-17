package com.loongxun.cbe.until;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	 /**图片格式：JPG*/
	      private static final String PICTRUE_FORMATE_JPG = "jpg";
	      
	      /**
	       * 添加图片水印
	       * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
	       * @param waterImg  水印图片路径，如：C://myPictrue//logo.png
	       * @param x 水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间
	       * @param y 水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间
	       * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	  */
	      public final static void pressImage(String targetImg, String waterImg, int x, int y, float alpha) {
	              try {
	            	   targetImg=targetImg.replaceAll("\\\\","\\\\\\\\");
	            	   waterImg=waterImg.replaceAll("\\\\","\\\\\\\\");
	                  File file = new File(targetImg);
	                  Image image = ImageIO.read(file);
	                 int width = image.getWidth(null);
	                  int height = image.getHeight(null);
	                  BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	                  Graphics2D g = bufferedImage.createGraphics();
	                  g.drawImage(image, 0, 0, width, height, null);
	                  File wfile = new File(waterImg);
	                  Image waterImage = ImageIO.read(wfile);    // 水印文件
	                  int width_1 = waterImage.getWidth(null);
	                  int height_1 = waterImage.getHeight(null);
	                  g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
	               
	                 int widthDiff = width - width_1;
	                int heightDiff = height - height_1;
	                 if(x < 0){
	                     x = widthDiff / 2;
	                 }else if(x > widthDiff){
	                     x = widthDiff;
	                 }
	                  if(y < 0){
	                     y = heightDiff / 2;
	                 }else if(y > heightDiff){
	                      y = heightDiff;
	                  }
	                  g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束
	                  g.dispose();
	                 ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, file);
	             } catch (IOException e) {
	                 e.printStackTrace();
	              }
	     }
	      /**
	            * 图片缩放
	            * @param filePath 图片路径
	            * @param height 高度
	            * @param width 宽度
	            * @param bb 比例不对时是否需要补白
	       */
	      public static void resize(String filePath, int height, int width, boolean bb) {
	    	           try {
	    	               double ratio = 0; //缩放比例    
	    	               File f = new File(filePath);   
	    	               BufferedImage bi = ImageIO.read(f);   
	    	               Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);   
	    	               //计算比例   
	    	               if ((bi.getHeight() > height) || (bi.getWidth() > width)) {   
	    	                   if (bi.getHeight() > bi.getWidth()) {   
	    	                       ratio = (new Integer(height)).doubleValue() / bi.getHeight();   
	    	                   } else {   
	    	                       ratio = (new Integer(width)).doubleValue() / bi.getWidth();   
	    	                   }   
	    	                   AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);   
	    	                   itemp = op.filter(bi, null);   
	    	               }   
	    	               if (bb) {   
	    	                   BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
	    	                   Graphics2D g = image.createGraphics();   
	    	                   g.setColor(Color.white);   
	    	                   g.fillRect(0, 0, width, height);   
	    	                   if (width == itemp.getWidth(null))   
	    	                       g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
	    	                   else  
	    	                       g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
	    	                   g.dispose();   
	    	                   itemp = image;   
	    	               }
	    	               ImageIO.write((BufferedImage) itemp, "jpg", f);   
	    	           } catch (IOException e) {
	    	               e.printStackTrace();
	    	           }
	    	       }
	    	   
}
