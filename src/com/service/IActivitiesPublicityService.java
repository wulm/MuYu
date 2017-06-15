package com.service;

import java.util.List;

import com.bean.MxActivitiesPublicityContent;
import com.bean.MxActivitiesPublicityData;

public interface IActivitiesPublicityService {

	/**
	 * ��ȡ����������б�
	 * @param activitiesType
	 * @return
	 */
	public List<MxActivitiesPublicityData> getActivitiesPublicityByType(int activitiesType);

	/**
	 * ����id��ȡ�������������
	 * @param pdID
	 * @return
	 */
	public MxActivitiesPublicityContent getActivitiesPublicityContent(int pdID);

	
	
}
