package com.ljk.modules.gen.utils;

import com.ljk.LjkDeviceCallCenterApplication;
import com.ljk.modules.common.common.Constant;
import com.ljk.modules.gen.service.SysGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 类的功能描述.
 *
 * @Auther ljk
 * @Date 2017/11/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LjkDeviceCallCenterApplication.class)
public class GenLocalUtils {
    @Resource
    private SysGeneratorService generatorService;

    @Test
    public void generatorCode(){
        byte[] bytes=generatorService.generatorCode(new String[]{"sys_gentest"}, Constant.genType.local.getValue());
    }
}
