package com.ljk.modules.quartz.dao;


import com.ljk.modules.common.dao.BaseDao;
import com.ljk.modules.quartz.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类ScheduleJobLogDao的功能描述:
 * 定时任务日志
 * @auther ljk
 * @date 2017-08-25 16:13:41
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
