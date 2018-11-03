package pers.design.cys.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录表单
 */
@Data
public class LoginForm {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
