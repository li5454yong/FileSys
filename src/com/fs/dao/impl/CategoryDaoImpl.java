package com.fs.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fs.dao.CategoryDao;
import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:38:31
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Resource
	private SessionFactory sf;
	
	public List<Category> findEntity(String hql, Object... objects){
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

	//获取分类（文件夹）列表
	@Override
	public List<Category> getCategoryList(String p_id,int u_id) {
		try {
			
			if(StringUtils.isNotEmpty(p_id)){
				String sql = "from Category where p_id=? and u_id=?";
				Query query = sf.getCurrentSession().createQuery(sql);
				query.setString(0, p_id);
				query.setInteger(1, u_id);
				return query.list();
			}else{
				String sql = "from Category where u_id=?";
				Query query = sf.getCurrentSession().createQuery(sql);
				query.setInteger(0, u_id);
				return query.list();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//新增分类
	public void save(Category category){
		sf.getCurrentSession().save(category);
	}

	/**
	 * 根据传入的分类自身id、用户id获取该分类所有的父类
	 */
	public List<Category> getParentList(String seltId,int userId) {
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT T2.self_id, T2.title,T2.p_id FROM "
				+ "( SELECT @r AS _id,(SELECT @r\\:=p_id FROM category WHERE "
				+ "self_id=_id) AS p_id,@l\\:=@l+1 AS lvl FROM (SELECT @r\\:=?, "
				+ "@l\\:=0) vars,category h WHERE @r<>0) T1 JOIN category T2  ON"
				+ " T1._id=T2.self_id where T2.u_id=? ORDER BY T1.lvl DESC ";
		
		SQLQuery query = sf.getCurrentSession().createSQLQuery(sql);
		
		
		query.setString(0, seltId);
		query.setInteger(1, userId);
		Iterator it = query.list().iterator();
		
		while(it.hasNext()){
			Category category = new Category();
			Object[] obj = (Object[])it.next();
			category.setSelf_id(obj[0].toString());
			category.setTitle(obj[1].toString());
			category.setP_id(obj[2].toString());
			list.add(category);
		}
		return list;
	}

	@Override
	public void paublicShare(int id, String shareUrl) {
		String sql = "update Category set public_share_path=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, shareUrl);
		query.setInteger(1, id);
		query.executeUpdate();
		
	}

	@Override
	public void privateShare(int id, String shareUrl, String pw) {
		String sql = "update Category set private_share_path=?,distill_pwd=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, shareUrl);
		query.setString(1, pw);
		query.setInteger(2, id);
		query.executeUpdate();
	}

	/**
	 * 根据公开分享链接获取文件夹列表
	 */
	public List<Category> getPaublicShare(String publicSharePath) {
		String sql = "from Category where public_share_path=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, publicSharePath);
		return query.list();
	}

	/**
	 * 根据id获取文件夹
	 */
	public Category get(int id) {
		
		Category category = (Category)sf.getCurrentSession().get(Category.class, id);
		
		return category;
	}
	
	/**
	 * 删除一个文件夹及其子文件夹
	 * @param userId
	 * @param category
	 */
	public void delete(int userId,Category category){
		
		//sf.getCurrentSession().delete(category);
		String sql = "delete from Category where u_id=? and p_id like ?";
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		
		query.setParameter(0, userId);
		query.setParameter(1, category.getSelf_id()+"%");
		
		query.executeUpdate();
	}
	
	public void delete(Category category){
		String sql = "delete from Category where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, category.getId());
		
		query.executeUpdate();
	}
}
