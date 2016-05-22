package com.fs.service;

import java.util.List;

import com.fs.entity.Share;

/**
 * @author lxg
 *
 * 2016年1月9日下午3:31:25
 */
public interface ShareService {

	public void batchEntityByHQL(List<Share> list, String shareUrl);

	public void batchEntityByHQL(List<Share> list, String shareUrl,
			String passwd);
	
	public int getPrivateShare(String url, String passwd);
	
	//根据url获取分享的文件信息
	public List<Share> getShareList(String url);
	
	//根据url获取分享的文件信息
	public List<Share> getShareList1(String url);
	
	public List<Share> getShareUrlList(int user_id);
}
