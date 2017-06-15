package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.bean.MxActivitiesPublicityContent;
import com.bean.MxActivitiesPublicityData;

import com.service.IActivitiesPublicityService;
import com.weixin.util.WeixinSignUtil;
import com.weixin.util.WeixinUtil;

public class MxActivitiesPublicityAction {

	private IActivitiesPublicityService activitiesPublicityService;

	/**
	 * ����*���������action�е�Ĭ�ϴ����� ����
	 */
	public String execute() throws Exception {

		return null;
	}

	/**
	 * ��ȡУ�ѻ����������б�
	 */
	public String getActivitiesPublicityList() {

		HttpServletRequest request = ServletActionContext.getRequest();
		
		/**
		 * �˷�����֤΢���û��Ƿ��Ѿ���ע���ں�
		 * ����struts.xml������noFucus��error����Ӧҳ��
		 */
		String validateStr=WeixinUtil.validateWeixinWebUser(request);
		if(validateStr!=null){
			return validateStr;
		}
		
		String activitiesType = request.getParameter("type");
		List<MxActivitiesPublicityData> activitiesPublicityList = activitiesPublicityService
				.getActivitiesPublicityByType(Integer.parseInt(activitiesType));

		if (activitiesPublicityList != null && activitiesType != null) {
			request.getSession().setAttribute("activitiesPublicityList",
					activitiesPublicityList);
			request.getSession().setAttribute("activitiesType",
					Integer.parseInt(activitiesType));
			request.getSession().setAttribute("appID",WeixinSignUtil.AppID);
		}
		return "ActivitiesPublicityList";
	}

	/**
	 * ��ת�������������ϸ����ҳ
	 * @return
	 */
	public String gotoActivitiesDetail(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		int pdID=Integer.parseInt(request.getParameter("publicityDataId"));
		MxActivitiesPublicityContent apd=activitiesPublicityService.getActivitiesPublicityContent(pdID);
			
					request.getSession().setAttribute("ActivitiesPublicityDetail",apd);
				
		return "ActivitiesPublicityDetail";
	}
	
	public String gotoArtEditor(){
		return "ArtEditor";
	}
	
	
	public IActivitiesPublicityService getActivitiesPublicityService() {
		return activitiesPublicityService;
	}

	public void setActivitiesPublicityService(
			IActivitiesPublicityService activitiesPublicityService) {
		this.activitiesPublicityService = activitiesPublicityService;
	}

}
