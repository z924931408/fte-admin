package com.zhu.fte.biz.common.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginReq {
    @NotEmpty(message = "账户不能为空")
    public String username;
    @NotEmpty(message = "密码不能为空")
    public String password;
}
