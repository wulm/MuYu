package com.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.MxUsersData;
import com.bean.PageBean;
import com.dao.ISysUsersDAO;

public class UserServiceImpl implements com.service.IUserService {
	
	private ISysUsersDAO sysUsersDAO;
	
	public ISysUsersDAO getSysUsersDAO() {
		return this.sysUsersDAO;
	}
	public void setSysUsersDAO(ISysUsersDAO userDAO) {
		this.sysUsersDAO = userDAO;
	}

	
	
	/**���ã���֤�û���¼
	 * ����1��username�û���
	 * ����2��password����
	 * ����ֵ���ɹ������û����󣬷���null
	 * ����ʱ�䣺8:17:12 PM  �����ߣ�wulm
	 */
	public MxUsersData validLogin(String username, String password) {

		MxUsersData user = sysUsersDAO.findSysUsersByNameAndPass(username,
				password);
		if (user != null) {
			return user;
		} else {
			return null;
		}

	}

	public MxUsersData getUserByID(Integer userId) {
		// TODO Auto-generated method stub
		try {
			MxUsersData User = sysUsersDAO.get(userId);
			if (User != null) {
				return User;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<MxUsersData> getAllUsers(){
		List<MxUsersData> list =sysUsersDAO.getAll();
		return list;
	}

	public PageBean<MxUsersData> queryForPage(int pageCurrent) {
		HashMap<String, String> conditionList=new HashMap<String, String>();
		
		HttpServletRequest request= ServletActionContext.getRequest();
		int userType=(Integer)
				(request.getSession().getAttribute("userType")
						==null?-1:request.getSession().getAttribute("userType"));
		
		String userName=(String) 
				(request.getSession().getAttribute("userName")
						==null?"":request.getSession().getAttribute("userName"));
		if(pageCurrent<=0){
			pageCurrent=1;
		}
		if(userType!=-1){
			conditionList.put("user_type=", userType+"");
		}
		if(userName!=""){
			conditionList.put("user_name like", " '%"+userName+"%'");
		}
		
		PageBean<MxUsersData> pb = sysUsersDAO.getUsersPageBean(conditionList,pageCurrent);	
		//System.out.println("service��pageBean:��ҳ��"+pb.getTotalPage()+";��ǰҳ��"+pb.getCurrentPage()+";�ܼ�¼��:"+pb.getAllRow());
		return pb;
	}
	public boolean validateWeixinUser(String openId) {
		// TODO Auto-generated method stub
		return sysUsersDAO.validateWeixinUser(openId);
	}
}
