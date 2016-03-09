package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fs.dao.ShareDao;
import com.fs.entity.Share;
import com.fs.service.ShareService;

/**
 * @author lxg
 *
 * 2016年1月9日下午4:27:07
 */
@Service
public class ShareServiceImpl implements ShareService {

	@Resource
	private ShareDao dao;
	
	@Override
	public void batchEntityByHQL(List<Share> list, String shareUrl) {

		dao.batchEntityByHQL(list, shareUrl);
	}

	@Override
	public void batchEntityByHQL(List<Share> list, String shareUrl,
			String passwd) {
		dao.batchEntityByHQL(list, shareUrl, passwd);
	}

	@Override
	public int getPrivateShare(String url, String passwd) {
		
		return dao.getPrivateShare(url, passwd);
	}

	@Override
	public List<Share> getShareList(String url) {
		
		return dao.getShareList(url);
	}

}
