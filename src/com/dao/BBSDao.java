package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.BBSUser;
import com.tools.BaseDao;

public class BBSDao {
	/**
	 * 查找是否有相同的用户名
	 * @param userId
	 * @return 找到返回true 失败返回null
	 */
	public String findUserId(String userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from bbs_user where userId=?";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps, new Object[] {userId});
			if(rs.next()) {
				return userId;
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return null;
	}
	/**
	 * 添加用户到数据库
	 * @param user
	 * @return 1-成功  0-失败
	 */
	public int addUser(BBSUser user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "insert into bbs_user(userId,userPsw,userAlice,userEmail,"
					+ "userSex,userCreateDate) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			return BaseDao.alter(ps, new Object[] {
					user.getUserId(),user.getUserPsw(),user.getUserAlice(),user.getUserEmail(),
					user.getUserSex(),user.getUserCreateDate()
			});
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return 0;
	}
	
	
}
