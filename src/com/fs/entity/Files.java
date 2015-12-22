package com.fs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author lxg
 * 
 * 文件表
 * 
 * 2015年12月7日下午9:41:14
 */

@Entity
public class Files {
	
	private int id;
	
	private String filename;
	
	private String filesize;
	
	private String filepath;
	
	private int user_id;
	
	private Date uploadDate; // 上传日期
	
	private String category_id; // 所属分类id
	
	private int downloadnum;  // 下载量
	
	private String filedesc; //  文件描述 
	
	private String public_share_path; // 公开分享路径
	
	private String private_share_path; // 私密分享路径
	
	private String distill_pwd; //私密分享文件提取密码
	
	private String filetype; // 文件类型
	
	private Date init_date;
	
	private Date upd_date;
	
	private String icon_path;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public int getDownloadnum() {
		return downloadnum;
	}

	public void setDownloadnum(int downloadnum) {
		this.downloadnum = downloadnum;
	}

	public String getFiledesc() {
		return filedesc;
	}

	public void setFiledesc(String filedesc) {
		this.filedesc = filedesc;
	}

	public String getPublic_share_path() {
		return public_share_path;
	}

	public void setPublic_share_path(String public_share_path) {
		this.public_share_path = public_share_path;
	}

	public String getPrivate_share_path() {
		return private_share_path;
	}

	public void setPrivate_share_path(String private_share_path) {
		this.private_share_path = private_share_path;
	}

	public String getDistill_pwd() {
		return distill_pwd;
	}

	public void setDistill_pwd(String distill_pwd) {
		this.distill_pwd = distill_pwd;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}

	public String getIcon_path() {
		return icon_path;
	}

	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}
	
	
}
