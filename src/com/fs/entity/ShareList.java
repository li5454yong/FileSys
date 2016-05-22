package com.fs.entity;

import java.util.Date;
import java.util.List;

/**
 * @author lxg
 *
 * 2016年3月9日下午10:00:14
 */
public class ShareList {

	private List<Category> categoryList;
	
	private List<Files> fileList;
	
	private String url;
	
	private Date init_date;
	
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<Files> getFileList() {
		return fileList;
	}
	public void setFileList(List<Files> fileList) {
		this.fileList = fileList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getInit_date() {
		return init_date;
	}
	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}
	
	
}
