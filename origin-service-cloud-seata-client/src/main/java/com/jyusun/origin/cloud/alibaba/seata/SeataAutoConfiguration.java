package com.jyusun.origin.cloud.alibaba.seata;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Seata 配置类
 *
 * @author jyusun at 2023-06-05 17:10:18
 */
@PropertySource(value = "classpath:seata-config.yml")
@Configuration(proxyBeanMethods = false)
public class SeataAutoConfiguration {

}
