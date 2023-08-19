package com.jyusun.origin.system.client.logger.handle;

import com.jyusun.origin.base.logger.api.LoggerOutput;
import com.jyusun.origin.base.logger.model.dto.ErrorLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.LoginLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.RequestLoggerDTO;
import com.jyusun.origin.base.logger.model.dto.UsualLoggerDTO;
import com.jyusun.origin.system.client.logger.feign.SysLoggerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 作用描述：日志处理
 *
 * @author jyusun at 2023/3/6 16:20
 * @since 1.0.0
 */
@Primary
@Component
@RequiredArgsConstructor
public class LoggerOutputHandle implements LoggerOutput {

    private final SysLoggerClient loggerClient;


    /**
     * @param loggerDTO
     */
    @Override
    public void login(LoginLoggerDTO loggerDTO) {
        this.loggerClient.sendLogin(loggerDTO);
    }

    @Override
    public void request(RequestLoggerDTO loggerDTO) {
        this.loggerClient.sendRequest(loggerDTO);
    }

    /**
     * @param loggerDTO
     */
    @Override
    public void usual(UsualLoggerDTO loggerDTO) {
        this.loggerClient.sendUsual(loggerDTO);
    }

    /**
     * @param loggerDTO
     */
    @Override
    public void error(ErrorLoggerDTO loggerDTO) {
        this.loggerClient.sendError(loggerDTO);
    }
}
