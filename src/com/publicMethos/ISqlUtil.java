package com.publicMethos;

import java.util.HashMap;
import java.util.List;

public interface ISqlUtil {
	
	public <T> List<T> queryHqlListBySession(String hql, T bean);

	public Object queryHqlBySession(String hql);

	public int executeUpdate(String hql);
	
	
}
