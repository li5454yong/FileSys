package com.fs.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

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
			String sql = "from Category where p_id=? and u_id=?";
			Query query = sf.getCurrentSession().createQuery(sql);
			query.setString(0, p_id);
			query.setInteger(1, u_id);
			return query.list();
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

	@Override
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
		String sql = "update Category set public_share_path=?,upd_date=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, shareUrl);
		query.setDate(1, new Date());
		query.setInteger(2, id);
		query.executeUpdate();
		
	}
}
