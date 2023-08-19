package com.jyusun.origin.admin.client.upms.model;

import com.jyusun.origin.core.common.model.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * 数据传输对象
 *
 * @author jyusun at2021-12-25 22:50:52
 */
@Data
@Accessors(chain = true)
@Schema(description = "数据传输对象：用户信息")
public class SysUserDTO implements BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @Schema(description = "用户编号")
    private Long userId;
    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
    private String username;
    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    private String password;

    /**
     * 启用状态
     */
    @Schema(description = "启用状态", example = "0-禁用|1-启用")
    private Boolean enabled;

    /**
     * 启用状态
     */
    @Schema(description = "用户是否过期", example = "0-已过期|1-未过期")
    private Boolean accountNonExpired;

    /**
     * 启用状态
     */
    @Schema(description = "用户凭证是否过期", example = "0-已过期|1-未过期")
    private Boolean credentialsNonExpired;

    /**
     * 启用状态
     */
    @Schema(description = "用户是否被锁定", example = "0-已锁定|1-未锁定")
    private Boolean accountNonLocked;

    /**
     * 角色集合
     */
    @Schema(description = "角色集合")
    private Set<String> roles;

    /**
     * 权限集合
     */
    @Schema(description = "权限集合")
    private Set<String> permissions;
}
