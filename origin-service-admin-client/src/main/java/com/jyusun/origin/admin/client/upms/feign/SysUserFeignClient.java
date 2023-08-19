package com.jyusun.origin.admin.client.upms.feign;

import com.jyusun.origin.admin.client.common.constant.SysNameConstant;
import com.jyusun.origin.admin.client.upms.api.SysUserApi;
import com.jyusun.origin.admin.client.upms.feign.fallback.SysUserClientFallbackFactory;
import com.jyusun.origin.admin.client.upms.model.SysUserDTO;
import com.jyusun.origin.admin.client.upms.model.SysUserRegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 系统账户
 * <p>
 * 作用描述：系统账户服务客户端
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:06
 * @since 1.0.0
 */
@Tag(name = "权限管理-Feign")
@FeignClient(contextId = "upms-user",value = SysNameConstant.ORIGIN_SYSTEM_UPMS,path = SysUserApi.API_PREFIX,
        fallbackFactory =
        SysUserClientFallbackFactory.class)
public interface SysUserFeignClient extends SysUserApi {

    /**
     * 查询用户信息
     *
     * @param username {@code String} 用户名
     * @return 用户信息
     */
    @Override
    @Operation(summary = "用户信息")
    @GetMapping(value =  "{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    SysUserDTO findUserInfo(@PathVariable String username);



    /**
     * 用户注册
     *
     * @param register {@link SysUserRegisterDTO} 用户注册
     * @return 用户信息
     *
     */
    @Override
    @Operation(summary = "用户注册")
    @GetMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean userRegister(@RequestBody SysUserRegisterDTO register);


}
