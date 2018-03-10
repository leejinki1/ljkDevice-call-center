package com.ljk.modules.sys.dao;

import com.ljk.modules.common.dao.BaseDao;
import com.ljk.modules.sys.entity.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 通知
 * 
 * @author ljk
 * @date 2017-08-31 15:59:09
 */
@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity> {

    /**
     * 我的通知列表
     * @param noticeEntity
     * @return
     */
    List<NoticeEntity> findMyNotice(NoticeEntity noticeEntity);
}
