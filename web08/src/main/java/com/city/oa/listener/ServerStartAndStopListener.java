package com.city.oa.listener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndStopListener
 *
 */
@WebListener
public class ServerStartAndStopListener implements ServletContextListener {

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	 System.out.println("服务器停止了");
    	 ServletContext application=event.getServletContext();
    	 String clickcount=application.getAttribute("clickcount").toString()+"\n\r";
    	 String path=application.getRealPath("/WEB-INF/info.txt");
    	 System.out.println(path);
    	 System.out.println(clickcount);
    	 try{
    		FileWriter fw = new FileWriter(path);
 	    	fw.write(clickcount);//将字符串写入到指定的路径下的文件中
 	    	fw.close();
 		 }catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		 }
    	 
    }

	/**
     * 监听服务器启动方法
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("服务器启动了");
        ServletContext application=event.getServletContext();
        //设置登录用户人数
        application.setAttribute("usercount",0);
        //设置网站点击次数
        BufferedReader reader = null;
        String path=application.getRealPath("/WEB-INF/info.txt");
        String line = null;
        try {
			reader = new BufferedReader(new FileReader(path));
			line=reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        application.setAttribute("clickcount",Integer.parseInt(line));
        //设置登录用户列表容器
    }
	
}
