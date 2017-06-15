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

	private IUserService userService;     //该对象采用 Spring 依赖注入
	
	//Spring依赖注入的对象必须有get、set方法。方法命名规则：get+变量名。为了便于记忆，变量名第一个字母可以大写。
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }
	
	public int pageCurrent=1; //当前显示的用户信息表页面标志
	
	@Override
	public String execute() throws Exception {
		//user.action调用的方法
		return "LoginSuccess";

	}

	
	/**作用：user!login.action调用的方法
	 * 返回值：String
	 * 创建时间：8:23:02 PM  创建者：wulm
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
	
	
	/**作用：局部刷新用户页面表格，根据传入页码和条件参数
	 * 返回值：
	 * 创建时间：5:50:37 PM  创建者：wulm
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
	        response.setContentType("text/plain;charset=UTF-8");//设置返回数据文本编码为utf-8
	        response.getWriter().write(jsonData);//返回json数据到前台
	        System.out.println(jsonData);
	        response.getWriter().flush();
	        
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
	
	
	
	/**作用：局部刷新用户页面表格，根据传入页码和条件参数
	 * 返回值：
	 * 创建时间：5:50:37 PM  创建者：wulm
	 */
	public void updateUserList() {
	    try {
	        List<MxUsersData> list = userService.getAllUsers();
	        PageBean buff=new PageBean();
	        buff.setList(list);
	        buff.setAllRow(list.size());
			JSONArray jsonList = JSONArray.fromObject(buff);//用户列表
			String jsonStr=jsonList.toString();
			jsonStr=jsonStr.replaceAll("list", "rows");
			jsonStr=jsonStr.replaceAll("allRow", "total");
			jsonStr=jsonStr.substring(1,jsonStr.length()-1);
	        HttpServletResponse response =   ServletActionContext.getResponse();
	        response.setContentType("text/plain;charset=UTF-8");//设置返回数据文本编码为utf-8
	        response.getWriter().write(jsonStr);//返回json数据到前台
	        System.out.println(jsonStr);
	        response.getWriter().flush();
	        
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
}
