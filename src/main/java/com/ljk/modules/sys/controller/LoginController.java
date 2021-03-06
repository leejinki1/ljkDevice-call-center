package com.ljk.modules.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ljk.modules.common.annotation.SysLog;
import com.ljk.modules.common.controller.BaseController;
import com.ljk.modules.common.utils.Result;
import com.ljk.modules.common.utils.ShiroUtils;
import com.ljk.modules.common.utils.UserUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 类的功能描述.
 * 登陆控制
 * @Auther ljk
 * @Date 2018/3/8
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login/login", method = RequestMethod.POST)
    public Result login(String username, String password, boolean isRememberMe)throws IOException {
      /*  String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return Result.error("验证码不正确");
        }*/
        try{
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(isRememberMe);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return Result.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return Result.error("账号或密码不正确");
        }catch (LockedAccountException e) {
            return Result.error("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return Result.error("账户验证失败");
        }

        return Result.ok();
    }

    /**
     * 方法logOut的功能描述:
     * 退出登陆
     * @params []
     * @return java.lang.String
     * @auther ljk
     * @date 2018-03-09 14:01:23
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    @SysLog("退出系统")
    public String logOut(){
        String loginName= UserUtils.getCurrentUser().getLoginName();

        ShiroUtils.logout();
        return "redirect:/login.html";
    }

}
