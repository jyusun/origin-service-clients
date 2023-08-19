package com.jyusun.origin.admin.client.info.feign.fallback;

import com.jyusun.origin.admin.client.info.feign.SysParamFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务降级工厂
 * <p>
 * 作用描述：系统账户服务降级
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:08
 * @since 1.0.0
 */
@Slf4j
@Component
public class SystemParamClientFallbackFactory implements FallbackFactory<SysParamFeignClient> {

    @Override
    public SysParamFeignClient create(Throwable cause) {
        return new SysParamFeignClientFallback(cause);
    }
}
