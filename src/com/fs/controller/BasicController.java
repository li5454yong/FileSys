package com.fs.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fs.entity.User;


public abstract class BasicController {

	@Autowired
	protected HttpSession session;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public String redirect(String path) {
		return "redirect:" + path;
	}

	public WebMessage saveError(Object message) {
		return new WebMessage(WebMessage.ERROR, message);
	}

	public WebMessage saveSuccess() {
		return saveSuccess("");
	}

	public WebMessage saveSuccess(Object message) {
		return new WebMessage(WebMessage.SUCCESS, message);
	}

	public User getAuthUser() {
		return (User) session.getAttribute("USER");
	}
}
