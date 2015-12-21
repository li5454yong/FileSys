package com.fs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:07:44
 */
@Entity
public class User {
	private int id;
	
	private String username;
	
	private String nickname;
	
	private String password;
	
	private double memory_space;
	
	private double used_space;
	
	private Date reg_date;
	
	private Date init_date;
	
	private Date upd_date;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMemory_space() {
		return memory_space;
	}

	public void setMemory_space(double memory_space) {
		this.memory_space = memory_space;
	}

	public double getUsed_space() {
		return used_space;
	}

	public void setUsed_space(double used_space) {
		this.used_space = used_space;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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
