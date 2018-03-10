package com.ljk.modules.sys.service;


import com.ljk.modules.sys.entity.UserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关系表
 * 
 * @author ljk
 * @date 2018-03-09 10:07:59
 */
public interface UserRoleService {
	
	UserRoleEntity queryObject(String userId);
	
	List<UserRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserRoleEntity userRole);
	
	void update(UserRoleEntity userRole);
	
	void delete(String userId);
	
	void deleteBatch(String[] userIds);

	void saveOrUpdate(String userId, List<String> roleIdList);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<String> queryRoleIdList(String userId);


}
