package com.fs.dao;

import java.util.List;

import com.fs.entity.Category;
import com.fs.entity.Share;

/**
 * @author lxg
 *
 * 2016年1月9日下午3:10:55
 */
public interface ShareDao {
	
	public void batchEntityByHQL(List<Share> list,String shareUrl);
	
	public void batchEntityByHQL(List<Share> list,String shareUrl,String passwd);
	
	public int getPrivateShare(String url,String passwd);
	
	public List<Category> getCategoryList(String p_id,String url);
}
