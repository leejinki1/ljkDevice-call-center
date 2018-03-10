package com.ljk.component.commandLineRunner;

import com.ljk.modules.common.utils.RedisUtil;
import com.ljk.modules.sys.dao.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 类的功能描述.
 * 服务启动执行
 * @Auther ljk
 * @Date 2017/11/14
 */
@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    private CodeDao codeDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务启动执行服务启动执行服务启动执行服务启动执行");
        //CodeCache();
    }


}
