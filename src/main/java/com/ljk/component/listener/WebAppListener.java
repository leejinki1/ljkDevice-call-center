package com.ljk.component.listener;

import com.ljk.modules.common.cache.CodeCache;
import com.ljk.modules.common.common.Constant;
import com.ljk.modules.common.utils.RedisUtil;
import com.ljk.modules.common.utils.StringUtils;
import com.ljk.modules.sys.dao.CodeDao;
import com.ljk.modules.sys.entity.CodeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class WebAppListener implements ApplicationListener<ContextRefreshedEvent> {
//@Configuration
//public class WebAppListener implements EnvironmentAware {
	private static final Logger logger = LoggerFactory.getLogger(WebAppListener.class);

	private RelaxedPropertyResolver propertyResolver;

	//@Value("${master.datasource.url}")
	//private String myUrl;
	 
	
	@Autowired
    ApplicationContext webApplicationContext;
	  
    @Autowired
	private CodeDao codeDao;
	
	@Autowired
	private RedisUtil redisUtils;

	/**
	 * 实现EnvironmentAware接口，初始化系统数据。
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		codeCache();
	}

    /**
     * 缓存全部数据字典
     */
    public void codeCache(){
        List<CodeEntity> allCode = codeDao.queryAllCode();
        Map<String,Map<String,Object>> allMap = new HashMap<>();
        if(allCode != null && allCode.size()>0){
            Map<String,Object> attrMap =null;
            for (CodeEntity code:allCode){
                attrMap= new HashMap<>();
                attrMap.put("id",code.getId());
                attrMap.put("value",code.getValue());
                attrMap.put("childs",code.getChilds());
                attrMap.put("mark",code.getMark());
                attrMap.put("name",code.getName());
                allMap.put(code.getMark(),attrMap);
            }
        }
        for (String key:allMap.keySet()){
            //父字典
            Map<String, Object> parentMap = allMap.get(key);
            String childStr = (String) parentMap.get("childs");
            if(StringUtils.isEmpty(childStr)){
                continue;
            }
            String[] split = childStr.split(",");
            List<Map<String, Object>> childMaps = new ArrayList<>();

            for (String str:split){
                //子字典
                Map<String, Object> childMap = allMap.get(str);
                childMaps.add(childMap);
            }
            //将所有子字典设置到父级字典
            parentMap.put("childList",childMaps);
        }
        CodeCache.put(Constant.CODE_CACHE,allMap);
        try {
            redisUtils.setObject(Constant.CODE_CACHE,allMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
