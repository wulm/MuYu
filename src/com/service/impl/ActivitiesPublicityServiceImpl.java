package com.service.impl;

import java.util.List;

import com.bean.MxActivitiesPublicityContent;
import com.bean.MxActivitiesPublicityData;
import com.dao.IActivitiesPublicityDAO;

public class ActivitiesPublicityServiceImpl implements com.service.IActivitiesPublicityService {
	
	private IActivitiesPublicityDAO activitiesPublicityDAO;
	
	/**���ã���������id��ȡ���������
	 * ����1��activitiesType�����
	 * ����ֵ���ɹ����ػ���£�����null
	 * �����ߣ�wulm
	 */
	public List<MxActivitiesPublicityData> getActivitiesPublicityByType(
			int activitiesType) {
		// TODO Auto-generated method stub
		return activitiesPublicityDAO.getActivitiesPublicityByType(activitiesType);
	}

	

	public IActivitiesPublicityDAO getActivitiesPublicityDAO() {
		return activitiesPublicityDAO;
	}

	public void setActivitiesPublicityDAO(IActivitiesPublicityDAO activitiesPublicityDAO) {
		this.activitiesPublicityDAO = activitiesPublicityDAO;
	}



	/**
	 * ����id��ȡ�������������
	 */
	public MxActivitiesPublicityContent getActivitiesPublicityContent(int pdID) {
		
		
		// TODO Auto-generated method stub
		return activitiesPublicityDAO.getActivitiesPublicityContent(pdID);
	}



	
}
