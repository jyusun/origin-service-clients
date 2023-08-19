package com.jyusun.origin.admin.client.info.feign.fallback;

import com.jyusun.origin.admin.client.info.feign.SysParamFeignClient;
import com.jyusun.origin.admin.client.info.model.SysParamDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * 系统参数
 *
 * @author jyusun
 */
@Slf4j
public class SysParamFeignClientFallback implements SysParamFeignClient {

    private final Throwable cause;

    public SysParamFeignClientFallback(Throwable throwable) {
        this.cause = throwable;
    }


    @Override
    public SysParamDTO findParam(String userName) {
        return null;
    }
}
