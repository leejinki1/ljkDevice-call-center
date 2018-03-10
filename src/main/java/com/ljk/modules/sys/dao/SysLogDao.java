package com.ljk.modules.sys.dao;

import com.ljk.modules.common.dao.BaseDao;
import com.ljk.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类SysLogDao的功能描述:
 * 系统日志
 * @auther leejinki
 * @date 2018-03-09 16:14:57
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
