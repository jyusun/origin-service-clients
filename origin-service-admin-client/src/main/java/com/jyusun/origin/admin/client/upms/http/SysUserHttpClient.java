package com.jyusun.origin.admin.client.upms.http;

import com.jyusun.origin.admin.client.upms.api.SysUserApi;
import com.jyusun.origin.admin.client.upms.model.SysUserDTO;
import com.jyusun.origin.admin.client.upms.model.SysUserRegisterDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
@Tag(name = "权限管理-Http")
@HttpExchange(SysUserApi.API_PREFIX)
public interface SysUserHttpClient extends SysUserApi {


    /**
     * 查询用户信息
     *
     * @param username {@code String} 用户名
     * @return 用户信息
     */
    @Override
    @Schema(description = "用户信息")
    @GetExchange(value = "{username}")
    SysUserDTO findUserInfo(@PathVariable String username);

    /**
     * 用户注册
     *
     * @param register {@link SysUserRegisterDTO} 用户注册
     * @return 用户信息
     */
    @Override
    @Schema(description = "用户注册")
    @GetExchange(value = "register")
    Boolean userRegister(@RequestBody SysUserRegisterDTO register);
}
