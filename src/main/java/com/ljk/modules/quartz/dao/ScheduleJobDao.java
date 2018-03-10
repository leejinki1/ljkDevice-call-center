package com.ljk.modules.quartz.dao;


import com.ljk.modules.common.dao.BaseDao;
import com.ljk.modules.quartz.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 类ScheduleJobDao的功能描述:
 * 定时任务
 * @auther ljk
 * @date 2017-08-25 16:14:04
 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
