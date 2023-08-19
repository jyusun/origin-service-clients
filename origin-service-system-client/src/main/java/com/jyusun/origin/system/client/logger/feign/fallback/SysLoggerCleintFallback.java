package com.jyusun.origin.system.client.logger.feign.fallback;

import com.jyusun.origin.base.logger.model.dto.ErrorLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.ExeSqlLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.LoginLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.RequestLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.UsualLoggerDTO;
import com.jyusun.origin.system.client.logger.feign.SysLoggerClient;
import lombok.RequiredArgsConstructor;

/**
 * @author jyusun at 13:59:21
 */
@RequiredArgsConstructor
public class SysLoggerCleintFallback implements SysLoggerClient {

    private final Throwable cause;

    @Override
    public Boolean sendUsual(UsualLoggerDTO usualLoggerDTO) {
        return null;
    }

    /**
     * 登录处理
     *
     * @param loginLoggerDTO {@link LoginLoggerDTO} 登录日志
     * @return {@link Boolean>}
     */
    @Override
    public Boolean sendLogin(LoginLoggerDTO loginLoggerDTO) {
        return null;
    }

    @Override
    public Boolean sendRequest(RequestLoggerDTO requestLoggerDTO) {
        return null;
    }

    @Override
    public Boolean sendError(ErrorLoggerDTO errorLoggerDTO) {
        return null;
    }

    /**
     * 异常信息
     *
     * @param exeSqlLoggerDTO {@link ErrorLoggerDTO} 错误日志
     * @return {@link Boolean>}
     */
    @Override
    public Boolean sendExeSql(ExeSqlLoggerDTO exeSqlLoggerDTO) {
        return null;
    }
}
