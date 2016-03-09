package com.fs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fs.dao.ShareDao;
import com.fs.entity.Category;
import com.fs.entity.Share;

/**
 * @author lxg
 *
 * 2016年1月9日下午3:12:17
 */
@Repository("shareDao")
public class ShareDaoIpml implements ShareDao {

	@Resource
	private SessionFactory sf;
	
	/**
	 * 插入用户分享的文件信息
	 */
	public void batchEntityByHQL(List<Share> list,String shareUrl) {

		for(Share s : list){
			s.setShareUrl(shareUrl);
			sf.getCurrentSession().save(s);
		}
	}

	@Override
	public void batchEntityByHQL(List<Share> list, String shareUrl,
			String passwd) {
		for(Share s : list){
			s.setShareUrl(shareUrl);
			s.setPw(passwd);
			sf.getCurrentSession().save(s);
		}
	}

	/**
	 * 根据url 获取私密分享的文件
	 */
	public int getPrivateShare(String url, String passwd) {
		
		int flag = 0;
		
		String sql = "from Share where shareUrl=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, url);
		List<Share> list = query.list();
		if(list.size()>0){
			Share s = list.get(0);
			if(!passwd.equals(s.getPw())){
				flag = 1; // 密码不正确
			}
		}else{
			flag = 2; //链接不存在
		}
		
		return flag;
	}

	@Override
	public List<Share> getShareList(String url) {
		String sql = "from Share where shareUrl=? and type=1";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, url);
		
		return query.list();
	}

}
