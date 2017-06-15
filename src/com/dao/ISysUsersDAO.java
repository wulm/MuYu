package com.dao;

import java.util.HashMap;
import java.util.List;

import com.bean.MxUsersData;
import com.bean.PageBean;
public interface ISysUsersDAO {
	
	/**
	 * ����open_id��ѯ�û��Ƿ��ע�����ں�  0�� 1��
	 * @param open_id
	 * @return
	 */
	public int isExistUser(String open_id);

	/**
     * ����û�
     * @param
     */ 
	public void addUser(MxUsersData userData);
	
	/**
     * ��ȡ�����û�
     * @param
     */ 
	public List<MxUsersData> getAll();
	
	/**
     * ����id�����û�
     * @param id ��Ҫ���ҵ��û�id
     */  
	MxUsersData get(Integer id);

    /**
     * �޸��û�
     * @param SysUsers ��Ҫ�޸ĵ��û�
     */  
    void update(MxUsersData SysUsers);

    /**
     * ɾ���û�
     * @param id ��Ҫɾ�����û�id
     */  
    void delete(Integer id);

    /**
     * �����û�������������û�
     * @param SysUsersname ��ѯ������û���
     * @param pass ��ѯ���������
     * @return ��Ӧ���û�
     */ 
    MxUsersData findSysUsersByNameAndPass(String SysUsersname , String password);
	
    /**
     * ���������б�ҳ��ֵ�����û�
     * @param conditionList sql��ѯ������������б�
     * @param pageNum ҳ��ֵ
     * @return ��Ӧ��PageBean���󣬰�����ҳ��ʾ�û���������Ϣ
     */ 
	PageBean<MxUsersData> getUsersPageBean(HashMap<String, String> conditionList,int pageNum);

	/**
	 * ͨ��openid��ȡ�û�
	 * @param parseInt
	 * @return
	 */
	public MxUsersData getUserByOpenId(String openId);

	/**
	 * �����û�״̬
	 * @param i
	 * @return
	 */
	public boolean setUserState(MxUsersData ur);

	public boolean validateWeixinUser(String openId);
	
	
	
}
