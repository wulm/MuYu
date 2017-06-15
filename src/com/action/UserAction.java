package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.bean.MxUsersData;
import com.bean.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

/**
 * @author Administrator  2017
 *
 */
public class UserAction extends ActionSupport {  
	
	private static final long serialVersionUID = 1L;

	private IUserService userService;     //�ö������ Spring ����ע��
	
	//Spring����ע��Ķ��������get��set������������������get+��������Ϊ�˱��ڼ��䣬��������һ����ĸ���Դ�д��
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }
	
	public int pageCurrent=1; //��ǰ��ʾ���û���Ϣ��ҳ���־
	
	@Override
	public String execute() throws Exception {
		//user.action���õķ���
		return "LoginSuccess";

	}

	
	/**���ã�user!login.action���õķ���
	 * ����ֵ��String
	 * ����ʱ�䣺8:23:02 PM  �����ߣ�wulm
	 */
	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		MxUsersData user = userService.validLogin(username, password);
		if (user != null) {
			this.pageCurrent=1;
			request.getSession().setAttribute("userType", -1);
	        request.getSession().setAttribute("userName", "");
			PageBean<MxUsersData> pageBean = userService.queryForPage(this.pageCurrent);
			request.getSession().removeAttribute("userType");
			request.getSession().removeAttribute("userName");
			request.getSession().setAttribute("pageBean", pageBean);
			request.getSession().setAttribute("currentUser", user);
			return "success";
		} else {
			return "fail";
		}
	}
		
	public String goToeditUser(int userId){
		
		return "editUser";
	}
	
	
	/**���ã��ֲ�ˢ���û�ҳ���񣬸��ݴ���ҳ�����������
	 * ����ֵ��
	 * ����ʱ�䣺5:50:37 PM  �����ߣ�wulm
	 */
	public void updateUserTable() {
	    try {
	    	HttpServletRequest request=ServletActionContext.getRequest();
	        int pageNum = Integer.parseInt(request.getParameter("pageNum")==null?"1":request.getParameter("pageNum"));
	        int userType = Integer.parseInt(request.getParameter("userType")==null?"-1":request.getParameter("userType"));
	        String userName = request.getParameter("userName")==null?"":request.getParameter("userType");
	        request.getSession().setAttribute("userType", userType);
	        request.getSession().setAttribute("userName", userName);
	        PageBean<MxUsersData> pageBean = userService.queryForPage(pageNum);
	        request.getSession().removeAttribute("userType");
			request.getSession().removeAttribute("userName");
			String jsonData = JSONObject.fromObject(pageBean).toString();
	        HttpServletResponse response =   ServletActionContext.getResponse();
	        response.setContentType("text/plain;charset=UTF-8");//���÷��������ı�����Ϊutf-8
	        response.getWriter().write(jsonData);//����json���ݵ�ǰ̨
	        System.out.println(jsonData);
	        response.getWriter().flush();
	        
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
	
	
	
	/**���ã��ֲ�ˢ���û�ҳ���񣬸��ݴ���ҳ�����������
	 * ����ֵ��
	 * ����ʱ�䣺5:50:37 PM  �����ߣ�wulm
	 */
	public void updateUserList() {
	    try {
	        List<MxUsersData> list = userService.getAllUsers();
	        PageBean buff=new PageBean();
	        buff.setList(list);
	        buff.setAllRow(list.size());
			JSONArray jsonList = JSONArray.fromObject(buff);//�û��б�
			String jsonStr=jsonList.toString();
			jsonStr=jsonStr.replaceAll("list", "rows");
			jsonStr=jsonStr.replaceAll("allRow", "total");
			jsonStr=jsonStr.substring(1,jsonStr.length()-1);
	        HttpServletResponse response =   ServletActionContext.getResponse();
	        response.setContentType("text/plain;charset=UTF-8");//���÷��������ı�����Ϊutf-8
	        response.getWriter().write(jsonStr);//����json���ݵ�ǰ̨
	        System.out.println(jsonStr);
	        response.getWriter().flush();
	        
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
}
