package pers.design.cys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pers.design.cys.dataobject.UserInfo;
import pers.design.cys.enums.ResultEnum;
import pers.design.cys.form.LoginForm;
import pers.design.cys.service.UserService;

import javax.validation.Valid;
import java.util.Map;

/**
 * 登录相关Controller
 */
@Controller
@RequestMapping("/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index(){

        return new ModelAndView("user/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm form,
                              BindingResult bindingResult,
                              Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }

        UserInfo userInfo = userService.findByUsername(form.getUsername());
        if(!userInfo.getPassword().equals(form.getPassword())){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.LOGIN_SUCCESS.getMessage());
        map.put("url", "/sell/order/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/logout")
    public ModelAndView logout(Map<String, Object> map){

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/index");
        return new ModelAndView("common/success", map);
    }

}
