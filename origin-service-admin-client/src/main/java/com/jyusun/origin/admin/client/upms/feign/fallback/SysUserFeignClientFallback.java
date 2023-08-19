package com.jyusun.origin.admin.client.upms.feign.fallback;

import com.jyusun.origin.admin.client.upms.feign.SysUserFeignClient;
import com.jyusun.origin.admin.client.upms.model.SysUserDTO;
import com.jyusun.origin.admin.client.upms.model.SysUserRegisterDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * 系统账户降级
 *
 * @author jyusun
 */
@Slf4j
public class SysUserFeignClientFallback implements SysUserFeignClient {

    private final Throwable cause;

    public SysUserFeignClientFallback(Throwable throwable) {
        this.cause = throwable;
    }


    @Override
    public SysUserDTO findUserInfo(String userName) {
        return null;
    }

    /**
     * 用户注册
     *
     * @param register {@link SysUserRegisterDTO} 用户注册
     * @return 用户信息
     */
    @Override
    public Boolean userRegister(SysUserRegisterDTO register) {
        return null;
    }
}
