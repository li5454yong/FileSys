package com.fs.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fs.dao.FilesDao;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Filing;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:41:09
 */
@Repository("filesDao")
public class FilesDaoImpl implements FilesDao {

	@Resource
	private SessionFactory sf;
	
	/**
	 * 获取文件列表
	 */
	@Override
	public List<Files> getFileList(String sql,String p_id,int u_id) {
		try {
			
			Query query = sf.getCurrentSession().createQuery(sql);
			query.setString(0, p_id);
			query.setInteger(1, u_id);
			return query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 保存上传文件记录
	 */
	@Override
	public void save(Files file) {

		sf.getCurrentSession().save(file);
		
	}

	/**
	 * 创建公开分享链接
	 */
	@Override
	public void paublicShare(int id, String shareUrl) {
		try{
			String sql = "update Files set public_share_path=? where id=?";
			Query query = sf.getCurrentSession().createQuery(sql);
			query.setString(0, shareUrl);
			query.setInteger(1, id);
			query.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * 创建私密分享链接
	 */
	@Override
	public void privateShare(int id, String shareUrl, String pw) {
		String sql = "update Files set private_share_path=?,distill_pwd=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, shareUrl);
		query.setString(1, pw);
		query.setInteger(2, id);
		query.executeUpdate();
	}

	/**
	 * 获取文件存档信息
	 */
	@Override
	public List<Filing> getFiling(int userId) {

		String sql = "select year(init_date),month(init_date),count(*) from Files where user_id=? group by month(init_date)";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setInteger(0, userId);
		Iterator it = query.list().iterator();
		List<Filing> list = new ArrayList<Filing>();
		while(it.hasNext()){
			Filing filing = new Filing();
			Object[] obj = (Object[])it.next();
			filing.setYear(obj[0].toString());
			filing.setMonth(obj[1].toString());
			filing.setNum(obj[2].toString());
			list.add(filing);
		}
		return list;
	
	
	}

}
