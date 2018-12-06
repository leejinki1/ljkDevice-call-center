package com.ljk.modules.call.service.impl;

import com.ljk.modules.call.dao.NumberRegionDao;
import com.ljk.modules.call.entity.NumberRegionEntity;
import com.ljk.modules.call.service.NumberRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("numberRegionService")
public class NumberRegionServiceImpl implements NumberRegionService {
	@Autowired
	private NumberRegionDao numberRegionDao;
	
	@Override
	public NumberRegionEntity queryObject(Long id){
		return numberRegionDao.queryObject(id);
	}
	
	@Override
	public List<NumberRegionEntity> queryList(Map<String, Object> map){
		return numberRegionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return numberRegionDao.queryTotal(map);
	}
	
	@Override
	public void save(NumberRegionEntity numberRegion){
		numberRegionDao.save(numberRegion);
	}
	
	@Override
	public void update(NumberRegionEntity numberRegion){
		numberRegionDao.update(numberRegion);
	}
	
	@Override
	public void delete(Long id){
		numberRegionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		numberRegionDao.deleteBatch(ids);
	}
	
}
