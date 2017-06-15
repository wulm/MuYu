package com.dao;

import java.util.HashMap;
import java.util.List;

import com.bean.MxUsersData;
import com.bean.PageBean;
public interface ISysUsersDAO {
	
	/**
	 * 根据open_id查询用户是否关注过公众号  0否 1是
	 * @param open_id
	 * @return
	 */
	public int isExistUser(String open_id);

	/**
     * 添加用户
     * @param
     */ 
	public void addUser(MxUsersData userData);
	
	/**
     * 获取所有用户
     * @param
     */ 
	public List<MxUsersData> getAll();
	
	/**
     * 根据id查找用户
     * @param id 需要查找的用户id
     */  
	MxUsersData get(Integer id);

    /**
     * 修改用户
     * @param SysUsers 需要修改的用户
     */  
    void update(MxUsersData SysUsers);

    /**
     * 删除用户
     * @param id 需要删除的用户id
     */  
    void delete(Integer id);

    /**
     * 根据用户名，密码查找用户
     * @param SysUsersname 查询所需的用户名
     * @param pass 查询所需的密码
     * @return 对应的用户
     */ 
    MxUsersData findSysUsersByNameAndPass(String SysUsersname , String password);
	
    /**
     * 根据条件列表、页码值查找用户
     * @param conditionList sql查询语句所需条件列表
     * @param pageNum 页码值
     * @return 对应的PageBean对象，包含分页显示用户的所有信息
     */ 
	PageBean<MxUsersData> getUsersPageBean(HashMap<String, String> conditionList,int pageNum);

	/**
	 * 通过openid获取用户
	 * @param parseInt
	 * @return
	 */
	public MxUsersData getUserByOpenId(String openId);

	/**
	 * 设置用户状态
	 * @param i
	 * @return
	 */
	public boolean setUserState(MxUsersData ur);

	public boolean validateWeixinUser(String openId);
	
	
	
}
