package com.fs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户分享文件的信息
 * @author lxg
 *
 * 2016年1月9日下午2:06:14
 */
@Entity
public class Share {

	private int id;
	
	private String shareUrl; //分享文件或文件夹的访问路径
	
	private int user_id; //用户id
	
	private String pw; //私密分享的文件提取码
	
	private int type; //类型：1-文件夹，2-文件
	
	private int f_id; //分享的文件或文件夹的id
	
	private Date init_date;
	
	private Date upd_date;
	
	private Date share_date;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Date getShare_date() {
		return share_date;
	}

	public void setShare_date(Date share_date) {
		this.share_date = share_date;
	}
	
	
}
