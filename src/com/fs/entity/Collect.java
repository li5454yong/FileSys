package com.fs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author lxg
 * 
 * 收藏表
 * 
 * 2015年12月7日下午9:35:46
 */
@Entity
public class Collect {
	
	private int id; // 主键 
	
	private int u_id; // 用户id
	
	private int f_id; // 文件id
	
	private Date init_date; // 记录生成时间
	
	private Date upd_date;  // 记录更新时间

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

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
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
	
	
}
