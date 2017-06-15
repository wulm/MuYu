package com.publicMethos;

import java.util.HashMap;
import java.util.List;

import com.bean.PageBean;

public interface ISqlUtil {
	
	public <T> List<T> queryHqlListBySession(String hql, T bean);

	public Object queryHqlBySession(String hql);

	public int executeUpdate(String hql);
	
	public <T> PageBean<T> queryForPage(
			String DB_table_name,String Primarykey,
			HashMap<String,String> conditionList,
			Class<T> bean,int pageCurrent);
}
