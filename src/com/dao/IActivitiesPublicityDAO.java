package com.dao;

import java.util.List;

import com.bean.MxActivitiesPublicityContent;
import com.bean.MxActivitiesPublicityData;

public interface IActivitiesPublicityDAO {

	/**
	 * ���ݻ����id��ȡ����������б�
	 */
	List<MxActivitiesPublicityData> getActivitiesPublicityByType(
			int activitiesType);

	/**
	 * ����id��ȡ�������������
	 * @param pdID
	 * @return
	 */
	MxActivitiesPublicityContent getActivitiesPublicityContent(int pdID);

}
