package com.ljk.modules.call.service;


import com.ljk.modules.call.entity.NumberRegionEntity;

import java.util.List;
import java.util.Map;

/**
 * 类NumberRegionService的功能描述:
 * 号码归属地
 * @auther ljk
 * @date 2017-08-25 16:14:27
 */
public interface NumberRegionService {
	
	NumberRegionEntity queryObject(Long id);
	
	List<NumberRegionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(NumberRegionEntity numberRegion);
	
	void update(NumberRegionEntity numberRegion);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
