package drawpictrue;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class DrawcCircle {

	public static void main(String[] args) {
		try {  
			//生成文件名
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//设置画大小
	        int picWidth=150,picHeight=150;  
	        BufferedImage bufferedImage = new BufferedImage(picWidth, picHeight, BufferedImage.TYPE_INT_ARGB);  
	        //创建背景
	        Graphics2D main = bufferedImage.createGraphics();  
	        //设置文字 背景抗锯齿
	        main.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        //设置背景色 大小
	        main.setColor(new Color(58, 208, 226));
	        //填充背景  
	        main.fillRoundRect(0, 0, picWidth, picHeight, 150, 150);
	        String username = "一个";
	        //设置字体大小位置
	        Font font = new Font("宋体", Font.BOLD, 50);
	        FontMetrics fm = new JLabel().getFontMetrics(font);
	        int widths = fm.stringWidth(username);
	        main.setFont(font);
	        main.setColor(Color.WHITE);
	        int width = picWidth/2 - widths/2;
	        int hight = picWidth/2 + fm.getAscent()-(fm.getAscent()+fm.getDescent())/2;
	        main.drawString(username, width, hight);
	        main.dispose();  
	        //保存图片  
	        ImageIO.write(bufferedImage, "png", new File("C:/Users/Administrator/Desktop/wsx/"+uuid+".jpg"));  
	        //删除物理图片
	        File file = new File("C:/Users/Administrator/Desktop/wsx/"+uuid+".jpg");
	        if (file.exists() && file.isFile()) {
	            file.delete();
	            System.out.println("成功");
	        } else {
	            System.out.println("删除单个文件" + "C:/Users/Administrator/Desktop/wsx/"+uuid+".jpg" + "失败！");
	        }
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
}
