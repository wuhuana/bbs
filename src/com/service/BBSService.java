package com.service;

import com.dao.BBSDao;
import com.pojo.BBSUser;

public class BBSService {
	private BBSDao bbsDao = new BBSDao();
	/**
	 * 查找是否有相同的用户名
	 * @param userId
	 * @return 找到返回true 失败返回null
	 */
	public String findUserId(String userId) {
		return bbsDao.findUserId(userId);
	}
	/**
	 * 添加用户到数据库
	 * @param user
	 * @return 1-成功  0-失败
	 */
	public int addUser(BBSUser user) {
		return bbsDao.addUser(user);
	}
}
