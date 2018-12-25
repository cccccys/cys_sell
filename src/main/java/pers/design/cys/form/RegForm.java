package pers.design.cys.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 注册表单
 */
@Data
public class RegForm {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "请确认您的密码")
    private String passwordAck;

}
