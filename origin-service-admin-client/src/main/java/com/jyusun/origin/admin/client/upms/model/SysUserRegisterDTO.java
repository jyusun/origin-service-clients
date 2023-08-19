package com.jyusun.origin.admin.client.upms.model;

import com.jyusun.origin.core.common.model.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户注册
 *
 * @author jyusun at 2022-04-01 21:50:49
 */
@Data
@Accessors(chain = true)
@Schema(description = "数据传输对象：用户注册")
public class SysUserRegisterDTO implements BaseDTO {

    /**
     * 用户账号
     */
    @Schema(description ="用户账号")
    private String username;

    /**
     * 用户密码
     */
    @Schema(description ="用户密码")
    private String password;

}
