package com.fs.util;

import java.io.File;
import java.text.DecimalFormat;

import org.junit.Test;

/**
 * @author lxg
 *
 * 2016年1月14日下午9:42:40
 */
public class FileUtil {
	
	/**
	 * 转换文件大小
	 * @param size
	 * @return
	 */
	public static String getFileSize(Long size){
		double d = size/1024.0;
		StringBuilder sb = new StringBuilder();
		if(d>1024){
			double s = size * 100 / (1024.0 * 1024.0) / 100.0;
			DecimalFormat df=new DecimalFormat("#.00");
			sb.append(df.format(s));
			sb.append(" M");
		}else{
			double s = size * 100 / 1024.0/ 100.0;
			DecimalFormat df=new DecimalFormat("#.00");
			sb.append(df.format(s));
			sb.append(" Kb");
		}
		return sb.toString();
	}
	
	/**
	 * 计算文件大小
	 * @param size
	 * @return
	 */
	public static float getDoubleSize(Long size){
		float s = (float) (size * 100 / (1024.0 * 1024.0) / 100.0);
		return s;
	}
	/**
	 * 根据文件类型获取文件类型的图标
	 * @param type
	 * @return
	 */
	public static String getIconPath(String type){
		String path = "";
		switch (type) {
			case "rar": path = "img/rar.png";break;
			case "zip": path = "img/zip.png";break;
			case "ppt": path = "img/pptx_win.png";break;
			case "pptx": path = "img/pptx_win.png";break;
			case "xls": path = "img/xlsx_win.png";break;
			case "jpg": path = "img/jpeg.png";break;
			case "jpeg": path = "img/jpeg.png";break;
			case "png": path = "img/png.png";break;
			case "pdf": path = "img/pdf.png";break;
			case "xlsx": path = "img/xlsx_win.png";break;
			case "txt": path = "img/text.png";break;
			case "avi": path = "img/avi.png";break;
			case "doc": path = "img/docx_win.png";break;
			case "docx": path = "img/docx_win.png";break;
			case "psd": path = "img/psd.png";break;
			case "mp3": path = "img/mp3.png";break;
			case "gif": path = "img/gif.png";break;
			case "exe": path = "img/exe.png";break;
			case "mp4": path = "img/mp4.png";break;
			case "vsd": path = "img/vsd.png";break;
			
			default:path = "img/ysj.png";break;
		}
		
		return path;
	}
	
	/**
	 * 获取文件下载时设置的类型
	 * @param type
	 * @return
	 */
	public static String getContentType(String type){
		String contentType = "";
		switch (type) {
		case "rar": contentType = "application/x-tar";break;
		case "zip": contentType = "application/zip";break;
		case "ppt": contentType = "application/x-ppt";break;
		case "pptx": contentType = "application/x-ppt";break;
		case "xls": contentType = "application/x-xls";break;
		case "jpg": contentType = "application/x-jpeg";break;
		case "jpeg": contentType = "application/x-jpeg";break;
		case "png": contentType = "application/x-png";break;
		case "pdf": contentType = "application/pdf";break;
		case "xlsx": contentType = "application/x-xls";break;
		case "txt": contentType = "text/plain";break;
		case "avi": contentType = "video/avi";break;
		case "doc": contentType = "application/msword";break;
		case "docx": contentType = "application/msword";break;
		case "psd": contentType = "application/x-ps";break;
		case "mp3": contentType = "audio/mp3";break;
		case "gif": contentType = "image/gif";break;
		case "exe": contentType = "application/octet-stream bin";break;
		case "mp4": contentType = "video/mpeg4";break;
		case "vsd": contentType = "application/x-vsd";break;
		
		//default:contentType = "img/ysj.png";break;
	}
		return contentType;
	}
	
	/**
	 * 递归删除文件或文件夹
	 */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();//递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
