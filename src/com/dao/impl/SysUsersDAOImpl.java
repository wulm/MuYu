package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MxUsersData;
import com.bean.PageBean;
import com.dao.ISysUsersDAO;
import com.publicMethos.ISqlUtil;

public class SysUsersDAOImpl extends HibernateDaoSupport implements ISysUsersDAO {

	public static final int pageLinesNum=3;//����ÿ��ҳ����ʾ���б�����
	public static final String DB_table_name="[JC_Web_System_DB].[dbo].[Sys_Users]";//�û����ݿ⼰���ݱ�����
	public static final String Primarykey="user_id";//�û����ݱ���������
	private ISqlUtil sqlUtil;//����ע��ִ���Զ���sql����ͨ����
	
	public ISqlUtil getSqlUtil() {
		return sqlUtil;
	}
	public void setSqlUtil(ISqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}

	public void delete(Integer id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(MxUsersData.class , id));
	}

	public List<MxUsersData> getAll() {
		return getHibernateTemplate().find("from com.bean.SysUsers");
	}
	
	public MxUsersData get(Integer id) {
		return getHibernateTemplate().get(MxUsersData.class , id);
	}

	public void update(MxUsersData user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	public MxUsersData findSysUsersByNameAndPass(String SysUsersname,
			String password) {
		
		List<MxUsersData> ul = getHibernateTemplate().find("from com.bean.SysUsers au where au.userLoginName = '"+ SysUsersname+"' and au.userPwd = '"+ password+"'");

		if (ul.size() == 1)
        {
			//System.out.println("�鵽һ���Ϸ��û�����");
			return ul.get(0);
            
        }
		return null;
	}

	public  PageBean<MxUsersData> getUsersPageBean(HashMap<String, String> conditionList,int pageNum){
		
		return sqlUtil.queryForPage(DB_table_name,Primarykey, conditionList, MxUsersData.class, pageNum);
		
		
	}
	
	
	//������ҳ��ֵ��ѯ����...δ����
	public List<MxUsersData> getByPageT_N(int pageNum,int userType, String userName){
		
		//���ֵ��͵ķ�ҳsql������������ÿҳ50����198*50=9900��ȡ��199ҳ���ݡ�
		//ÿҳ��ʾm����ȡ��nҳ����rownuber>m*(n-1),rownuber<m*(n-1)+m+1
		int min=pageLinesNum*(pageNum-1);
		int max=pageLinesNum*pageNum+1;
		String sql="select * from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		if(userType==-1){
			sql+=" and user_name like '%"+userName+"%'";
		}else{
			sql+=" and user_type="+userType+" and user_name like '%"+userName+"%'";
		}
		
		List<MxUsersData> list=(List<MxUsersData>) sqlUtil.queryHqlBySession(sql);
		return list;
	}
	
/*	//��ȡ��ѯҳ����������δ����
	public int getPageCounts(){
		String sql="";
		sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		return (int)Math.ceil((double)((Integer)sqlUtil.queryHqlBySession(sql))/pageLinesNum);//ͨ������ע��ִ��hql���
	}*/
	
	//������   ��ȡ��ѯҳ������...δ����
	public int getPageCountsByT_N(int userType, String userName){
		String sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		if(userType==-1){
			 sql+="where user_name like '%"+userName+"%'";
		}else{
			sql+="where user_type="+userType+" and " +
				"user_name like '%"+userName+"%'";
		}
		//SQLManager sqlManager=(SQLManager)SqlUtil.getBean("sqlManager");
		return (int)Math.ceil((double)((Integer)sqlUtil.queryHqlBySession(sql))/pageLinesNum);//ͨ������ע��ִ��hql���
	}
	
	//������û�
	public void addUser(MxUsersData userData) {
		
		getHibernateTemplate().save(userData);
		
	}
	public MxUsersData getUserByOpenId(String openId) {
		// TODO Auto-generated method stub
		List<MxUsersData> mud=getHibernateTemplate().find("from com.bean.MxUsersData au where au.weixinOpenId ='"+openId+"'");
		if(mud.size()!=0){
			return (MxUsersData) mud.get(0);
		}else{
			return null;
		}
		
	}
	public boolean setUserState(MxUsersData ur) {
		// TODO Auto-generated method stub
		String sql="update [MXDB].[dbo].[MX_users_data] set user_state="+ur.getUserState()+" where weixin_openID='"+ur.getWeixinOpenId()+"'";
		if(sqlUtil.executeUpdate(sql)>0){
			return true;
		}
		return false;
	}
	
	public boolean validateWeixinUser(String openId) {
		// TODO Auto-generated method stub
		
		List<MxUsersData> ud= getHibernateTemplate().find("from com.bean.MxUsersData au where au.weixinOpenId ='"+openId+"' and au.userState=0");
		if(ud.size()==0){
			return false;
		}else{
			return true;
		}
	}
	public int isExistUser(String open_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
