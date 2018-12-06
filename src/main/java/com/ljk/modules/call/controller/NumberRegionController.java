package com.ljk.modules.call.controller;

import com.ljk.modules.call.entity.NumberRegionEntity;
import com.ljk.modules.call.service.NumberRegionService;
import com.ljk.modules.common.annotation.SysLog;
import com.ljk.modules.common.utils.PageUtils;
import com.ljk.modules.common.utils.Query;
import com.ljk.modules.common.utils.Result;
import com.ljk.modules.oss.entity.SysConfigEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 类NumberRegionController的功能描述:
 * 号码归属地
 * @auther ljk
 * @date 2017-08-25 16:20:16
 */
@RestController
@RequestMapping("/call/numberRegion")
public class NumberRegionController {
	@Autowired
	private NumberRegionService numberRegionService;

	/**
	 * 所有归属地列表
	 */
	//@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("call:numberRegion:list")
	@SysLog("查看号码归属地列表")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<NumberRegionEntity> numberRegionList = numberRegionService.queryList(query);
		int total = numberRegionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(numberRegionList, total, query.getLimit(), query.getPage());
	//	System.out.println(total);
	//	System.out.println(numberRegionList);
	//	System.out.println(params);
		return Result.ok().put("page", pageUtil);

	}

	/**
	 * 配置信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("call:numberRegion:info")
	@SysLog("查看系统配置信息")
	public Result info(@PathVariable("id") Long id){
		NumberRegionEntity region = numberRegionService.queryObject(id);
		System.out.println(region);
		return Result.ok().put("region", region);
	}
}
