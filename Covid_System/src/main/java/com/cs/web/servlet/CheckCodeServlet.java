package com.cs.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CheckCode", value = "/CheckCode")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=90;
        int height=40;
        //1.创建对象，在内存中以图片形式（验证码）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics pen = image.getGraphics();//画笔对象
        pen.setColor(Color.GRAY);//*色
        pen.fillRect(0,0,width,height);//填充
        //2.2边框
        pen.setColor(Color.black);
        pen.drawRect(0,0,width-1,height-1);

        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        pen.setFont(new Font("宋体", Font.BOLD, 28));
        //随机生成
        Random random = new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            char ch = str.charAt(random.nextInt(str.length()));
            sb.append(ch);
            pen.drawString(ch+"",width/5*i,height*2/3);
        }
        String checkCode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        //2.4干扰线
        pen.setColor(Color.black);
        //2.5随机生成点
        for (int i = 0; i < 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            pen.drawLine(x1,y1,x2,y2);
        }
        ImageIO.write(image,"jpg",response.getOutputStream());
    }
}
