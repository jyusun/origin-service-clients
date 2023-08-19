package com.jyusun.origin.admin.client.upms.api;

import com.jyusun.origin.core.common.util.StringUtil;
import com.jyusun.origin.admin.client.upms.model.SysUserDTO;
import com.jyusun.origin.admin.client.upms.model.SysUserRegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


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
@Tag(name = "权限管理-客户端")
public interface SysUserApi {

    /**
     * api版本
     */
    String API_VERSION = "v1/api";

    /**
     * API前缀
     */
    String API_PREFIX = API_VERSION + StringUtil.SLASH + "users";

    /**
     * 查询用户信息
     *
     * @param username {@code String} 用户名
     * @return 用户信息
     */
    @Operation(summary = "用户信息")
    SysUserDTO findUserInfo(String username);

    /**
     * 用户注册
     *
     * @param register {@link SysUserRegisterDTO} 用户注册
     * @return 用户信息
     */
    @Operation(summary = "用户注册")
    Boolean userRegister(SysUserRegisterDTO register);


}
