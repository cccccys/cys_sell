package pers.design.cys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pers.design.cys.dataobject.UserInfo;
import pers.design.cys.enums.ResultEnum;
import pers.design.cys.form.LoginForm;
import pers.design.cys.form.RegForm;
import pers.design.cys.service.UserService;
import pers.design.cys.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * 登录相关Controller
 */
@Controller
@RequestMapping("/")
@Slf4j
@Configuration
public class UserController {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index() {

        return new ModelAndView("user/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm form,
                              BindingResult bindingResult,
                              HttpServletResponse response,
                              Map<String, Object> map) throws Exception{

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }

        UserInfo userInfo = userService.findByUsername(form.getUsername());
        // 用户不存在
        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }
        // 密码不正确
        if (!userInfo.getPassword().equals(form.getPassword())) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }

        //set Cookie
        CookieUtil.set(response, "username", userInfo.getUsername(), 7200);
        CookieUtil.set(response, "type", String.valueOf(userInfo.getUserType()), 7200);

        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_27);
        cfg.setSharedVariable("type", userInfo.getUserType());

        map.put("msg", ResultEnum.LOGIN_SUCCESS.getMessage());
        map.put("url", "/sell/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 返回注册页面
     *
     * @return
     */
    @GetMapping("/logon")
    public ModelAndView logon() {
        return new ModelAndView("user/reg");
    }

    @PostMapping("/reg")
    public ModelAndView reg(@Valid RegForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map) {
        // 表单验证
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/logon");
            return new ModelAndView("common/error", map);
        }
        // 验证两次密码是否一致
        if (!form.getPassword().equals(form.getPasswordAck())) {
            map.put("msg", ResultEnum.PASSWORD_INCONSISTENT.getMessage());
            map.put("url", "/sell/logon");
            return new ModelAndView("common/error", map);
        }

        UserInfo userInfo = new UserInfo(form.getUsername(), form.getPassword(), Integer.valueOf(form.getUserType()));
        try {
            userService.save(userInfo);
        } catch (Exception e) {
            map.put("msg", ResultEnum.REG_FAILED.getMessage());
            map.put("url", "/sell/logon");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.REG_SUCCESS.getMessage());
        map.put("url", "/sell/index");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {

        // 清除Cookie
        Cookie username = CookieUtil.get(request, "username");
        Cookie type = CookieUtil.get(request, "type");
        if (username != null || type != null) {
            CookieUtil.set(response, "username", null, 0);
            CookieUtil.set(response, "type", null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/index");
        return new ModelAndView("common/success", map);
    }

}
