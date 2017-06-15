package com.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MxActivitiesPublicityContent;
import com.bean.MxActivitiesPublicityData;
import com.bean.MxUsersData;
import com.dao.IActivitiesPublicityDAO;

public class ActivitiesPublicityDAOImpl extends HibernateDaoSupport implements IActivitiesPublicityDAO{

	/**
	 * 根据类型id获取活动宣传文章
	 * 
	 */
	public List<MxActivitiesPublicityData> getActivitiesPublicityByType(
			int activitiesType) {
		List<MxActivitiesPublicityData> publicityList = getHibernateTemplate().find("from com.bean.MxActivitiesPublicityData au where au.actvitiesTypeId = "+ activitiesType);
		
		return publicityList;
	}

	public MxActivitiesPublicityContent getActivitiesPublicityContent(int pdID) {
		// TODO Auto-generated method stubcom.bean.MxActivitiesPublicityContent.publicitityDataId
		//return getHibernateTemplate().get(MxActivitiesPublicityContent.class , pdID);
		return (MxActivitiesPublicityContent) getHibernateTemplate().find("from com.bean.MxActivitiesPublicityContent au where au.publicityDataId = "+ pdID).get(0);
	}


}
