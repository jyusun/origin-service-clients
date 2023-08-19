package com.jyusun.origin.system.client.logger.api;


import com.jyusun.origin.base.logger.model.dto.ErrorLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.ExeSqlLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.LoginLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.RequestLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.UsualLoggerDTO;
import com.jyusun.origin.core.common.model.result.AbstractResult;
import com.jyusun.origin.core.common.util.StringUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public interface SysLoggerApi {
    /**
     * api版本
     */
    String API_VERSION = "v1/api";

    /**
     * API前缀
     */
    String API_PREFIX = API_VERSION + StringUtil.SLASH + "loggers";

    /**
     * 常规日志
     *
     * @param usualLogger {@link UsualLoggerDTO} 业务日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(summary = "日志发送：常规日志")
    Boolean sendUsual(@RequestBody UsualLoggerDTO usualLogger);

    /**
     * 登录处理
     *
     * @param loginLogger {@link LoginLoggerDTO} 登录日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(summary = "日志发送：登录日志")
    Boolean sendLogin(@RequestBody LoginLoggerDTO loginLogger);


    /**
     * 请求处理
     *
     * @param requestLogger {@link RequestLoggerDTO} 请求日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(summary = "日志发送：请求日志")
    Boolean sendRequest(@RequestBody RequestLoggerDTO requestLogger);

    /**
     * 错误信息
     *
     * @param errorLogger {@link ErrorLoggerDTO} 错误日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(summary = "日志存储：错误日志")
    Boolean sendError(@RequestBody ErrorLoggerDTO errorLogger);

    /**
     * 异常信息
     *
     * @param exeSqlLogger {@link ErrorLoggerDTO} 错误日志
     * @return {@link AbstractResult<Boolean>}
     */
    @Operation(summary = "日志存储：SQL日志")
    Boolean sendExeSql(@RequestBody ExeSqlLoggerDTO exeSqlLogger);


}
