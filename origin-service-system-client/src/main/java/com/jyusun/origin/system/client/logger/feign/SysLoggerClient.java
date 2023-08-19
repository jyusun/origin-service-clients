package com.jyusun.origin.system.client.logger.feign;


import com.jyusun.origin.base.logger.model.dto.ErrorLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.ExeSqlLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.LoginLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.RequestLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.UsualLoggerDTO;
import com.jyusun.origin.core.common.model.result.AbstractResult;
import com.jyusun.origin.system.client.common.constant.SysNameConstant;
import com.jyusun.origin.system.client.logger.api.SysLoggerApi;
import com.jyusun.origin.system.client.logger.feign.fallback.SysLoggerClientFallbackFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Feign 客户端
 *
 * <p>
 * 作用描述：日志收集
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:06
 * @since 1.0.0
 */
@Tag(name = "日志管理-提供者")
@FeignClient(contextId = "logger", value = SysNameConstant.ORIGIN_SYSTEM_LOGGER, path = SysLoggerApi.API_PREFIX
        , fallbackFactory = SysLoggerClientFallbackFactory.class)
public interface SysLoggerClient extends SysLoggerApi {

    /**
     * 常规日志
     *
     * @param usualLogger {@link UsualLoggerDTO} 业务日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(description = "日志发送：常规日志")
    @PostMapping(value = "usual", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    Boolean sendUsual(@RequestBody UsualLoggerDTO usualLogger);

    /**
     * 登录处理
     *
     * @param loginLogger {@link LoginLoggerDTO} 登录日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(description = "日志发送：登录日志")
    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    Boolean sendLogin(@RequestBody LoginLoggerDTO loginLogger);


    /**
     * 请求处理
     *
     * @param requestLogger {@link RequestLoggerDTO} 请求日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(description = "日志发送：请求日志")
    @PostMapping(value = "req", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    Boolean sendRequest(@RequestBody RequestLoggerDTO requestLogger);

    /**
     * 错误信息
     *
     * @param errorLoggerDTO {@link ErrorLoggerDTO} 错误日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(description = "日志存储：错误日志")
    @PostMapping(value = "error", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    Boolean sendError(@RequestBody ErrorLoggerDTO errorLoggerDTO);

    /**
     * 异常信息
     *
     * @param exeSqlLoggerDTO {@link ErrorLoggerDTO} 错误日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(description = "日志存储：SQL日志")
    @PostMapping(value = "exesql", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    Boolean sendExeSql(@RequestBody ExeSqlLoggerDTO exeSqlLoggerDTO);


}
