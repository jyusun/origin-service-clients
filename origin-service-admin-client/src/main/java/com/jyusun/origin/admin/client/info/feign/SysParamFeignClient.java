package com.jyusun.origin.admin.client.info.feign;

import com.jyusun.origin.admin.client.common.constant.SysNameConstant;
import com.jyusun.origin.admin.client.info.api.SysParamApi;
import com.jyusun.origin.admin.client.info.feign.fallback.SystemParamClientFallbackFactory;
import com.jyusun.origin.admin.client.info.model.SysParamDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 参数管理
 * <p>
 * 作用描述：参数管理客户端
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:06
 * @since 1.0.0
 */
@Tag(name = "系统管理-系统参数-客户端")
@FeignClient(contextId = "info-param",value = SysNameConstant.ORIGIN_SYSTEM_INFO, path = SysParamApi.API_PREFIX,
        fallbackFactory =
        SystemParamClientFallbackFactory.class)
public interface SysParamFeignClient extends SysParamApi {


    /**
     * 查询参数
     *
     * @param paramKey {@code String} 参数Key
     * @return 系统参数
     */
    @Override
    @Schema(description = "系统参数")
    @GetMapping(value = "{paramKey}", produces = MediaType.APPLICATION_JSON_VALUE)
    SysParamDTO findParam(@PathVariable("paramKey") String paramKey);

}
