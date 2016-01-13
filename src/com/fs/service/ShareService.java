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
}
