package com.fs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.junit.Test;

/**
 * 文件夹压缩工具类
 * @author lxg
 *
 * 2016年1月18日下午8:10:02
 */
public class PackFilesUtil {
    
   
    public static void zip(List<String> list,String packFileName) throws Exception {
        String zipFileName = packFileName; //打包后文件名字
        System.out.println(zipFileName);
        zip(zipFileName, list);
    }

    private static void zip(String zipFileName, List<String> list) throws Exception {
        ZipOutputStream o = new ZipOutputStream(new FileOutputStream(zipFileName));
        o.setEncoding(System.getProperty("sun.jnu.encoding"));//设置文件名编码方式
        for(String str : list){
        	File f = new File(str);
        	System.out.println(f.isDirectory());
        	zip(o, f, str.substring(str.lastIndexOf("/")+1, str.length()));
        }
        System.out.println("压缩完成");
        o.close();
    }

    private static void zip(ZipOutputStream o, File f, String base) throws Exception {
       
    	if (f.isDirectory()) {
           File[] fl = f.listFiles();
           o.putNextEntry(new ZipEntry(base + "/"));
           o.setEncoding(System.getProperty("sun.jnu.encoding"));//设置文件名编码方式
           base = base.length() == 0 ? "" : base + "/";
           for (int i = 0; i <fl.length; i++) {
           zip(o, fl[i], base + fl[i].getName());
         }
        }else {
           o.putNextEntry(new ZipEntry(base));
           o.setEncoding(System.getProperty("sun.jnu.encoding"));//设置文件名编码方式
           FileInputStream in = new FileInputStream(f);
           int b;
           System.out.println(base);
           while ( (b = in.read()) != -1) {
            o.write(b);
         }
         in.close();
       }
    }

    @Test
    public void demo() throws Exception{
    	List<String> l = new ArrayList<String>();
    	l.add("D:\\FileSys\\upload\\15628418747\\教程");
    	l.add("D:\\FileSys\\upload\\15628418747\\上海融义投资咨询有限公司-接口文档.rar");
    	zip(l,"D:\\test.zip");
    }
}