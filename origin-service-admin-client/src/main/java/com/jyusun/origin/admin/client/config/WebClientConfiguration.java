package com.jyusun.origin.admin.client.config;

import com.jyusun.origin.admin.client.upms.http.SysUserHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * WebClient配置
 * Reactive 需要引入 webflux
 *
 * @author jyusun
 * @since 0.0.1
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class WebClientConfiguration {

    @Bean
    public SysUserHttpClient albumsClient(WebClient.Builder webClientBuilder) {
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:11001").build();
        return HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(webClient)) //
                .build().createClient(SysUserHttpClient.class);
    }

}
