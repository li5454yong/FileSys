package com.fs.service;

import java.util.List;

import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:52:17
 */
public interface CategoryService {

	//验证该分类是否存在
	public boolean getCategoryByName(String name,int u_id,String pId);
	
	//获取分类（文件夹）列表
	public List<Category> getCategoryList(String p_id,int u_id);
	
	//创建公开链接
	public void paublicShare(int id,String shareUrl);
	
	
	//创建私密链接
	public void privateShare(int id,String shareUrl,String pw);
		
	//新增分类
	public void save(Category category);
	
	//获取所有父类
	public List<Category> getParentList(String seltId,int userId);
	
	public List<Category> getPaublicShare(String publicSharePath);
}
