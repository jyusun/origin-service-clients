package com.jyusun.origin.system.client.logger.feign.fallback;

import com.jyusun.origin.system.client.logger.feign.SysLoggerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 作用描述：字典客户端服务降级
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:08
 * @since 1.0.0
 */

@Slf4j
@Component
public class SysLoggerClientFallbackFactory implements FallbackFactory<SysLoggerClient> {


    @Override
    public SysLoggerClient create(Throwable cause) {
        return new SysLoggerCleintFallback(cause);
    }

}
