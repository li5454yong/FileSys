package com.fs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author lxg
 * 
 *  分类实体类
 * 
 * 2015年12月7日下午9:07:27
 */
@Entity
public class Category {
	
	private int id; //主键
	
	private int u_id;  //用户id
	
	private String p_id; //上级分类id
	
	private String self_id; // 分类自身id
	
	private String title;  // 分类标题
	
	private String public_share_path; // 公开分享路径
	
	private String private_share_path; // 私密分享路径
	
	private String distill_pwd; //私密分享文件提取密码
	
	private Date init_date;  // 记录生成日期
	
	private Date upd_date;  // 更新日期

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getSelf_id() {
		return self_id;
	}

	public void setSelf_id(String self_id) {
		this.self_id = self_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	
}
