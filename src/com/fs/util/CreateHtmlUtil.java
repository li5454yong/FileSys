package com.fs.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.junit.Test;

import com.fs.entity.Files;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author lxg
 * 
 *         2016年1月7日下午9:19:48
 */
public class CreateHtmlUtil {

	/**
	 * 生成静态网页
	 * @param list
	 * @param context
	 * @param htmlPath
	 */
	@SuppressWarnings("deprecation")
	public static void createHtmlForList(List<Object> list, ServletContext context,String htmlPath) {
		try {
			// 开始设置Freemarker
			Configuration cfg = new Configuration();
			// 设置Freemarker默认编码，如果不设，FreeMarker在遇见中文操作系统时，会使用默认的GBK编码方式
			cfg.setDefaultEncoding("UTF-8");
			// 设置模板文件所在的目录
			cfg.setServletContextForTemplateLoading(context, "/");

			// 取得模板文件
			Template t = cfg.getTemplate("WEB-INF/template/Share.ftl");
			// 设置响应编码

			// 将需要在客户端浏览器中显示的业务数据放在一个map中，传递给FreeMarker
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("file", list);

			File htmlFile = new File(htmlPath);
			// 判断路径是否存在，不存在则创建相应路径
			if (!htmlFile.getParentFile().exists()) {
				htmlFile.getParentFile().mkdirs();
			}

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "utf-8"));// 创建输出
			try {
				t.process(root, out);
			} catch (TemplateException e) {
				e.printStackTrace();
			}// 执行输出操作
			out.flush();
		} catch (Exception e) {

		}
	}
	
	public static void createHtmlForFile(Files file, ServletContext context,String htmlPath) {
		try {
			// 开始设置Freemarker
			Configuration cfg = new Configuration();
			// 设置Freemarker默认编码，如果不设，FreeMarker在遇见中文操作系统时，会使用默认的GBK编码方式
			cfg.setDefaultEncoding("UTF-8");
			// 设置模板文件所在的目录
			cfg.setServletContextForTemplateLoading(context, "/");

			// 取得模板文件
			Template t = cfg.getTemplate("WEB-INF/template/publicShareFile.ftl");
			// 设置响应编码

			// 将需要在客户端浏览器中显示的业务数据放在一个map中，传递给FreeMarker
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("file", file);

			File htmlFile = new File(htmlPath);
			// 判断路径是否存在，不存在则创建相应路径
			if (!htmlFile.getParentFile().exists()) {
				htmlFile.getParentFile().mkdirs();
			}

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "utf-8"));// 创建输出
			try {
				t.process(root, out);
			} catch (TemplateException e) {
				e.printStackTrace();
			}// 执行输出操作
			out.flush();
			out.close();
		} catch (Exception e) {

		}
	}

	/**
	 * 获取项目绝对路径
	 * @return
	 */
	public static String getPath(){
		String str = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//String str = "/D:/tomcat/tomcat-7-64/webapps/TestHtml5Upload/WEB-INF/classes/";
		
		str = str.substring(1,str.length());
		str = str.replace("WEB-INF/classes/", "");
		
		return str;
	}
}
