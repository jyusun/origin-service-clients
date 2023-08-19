package com.jyusun.origin.admin.client.info.http;

import com.jyusun.origin.admin.client.info.api.SysParamApi;
import com.jyusun.origin.admin.client.info.model.SysParamDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


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
@Tag(name = "系统参数-HTTP")
@HttpExchange(SysParamApi.API_PREFIX)
public interface SysParamHttpClient extends SysParamApi {


    /**
     * 查询参数
     *
     * @param paramKey {@code String} 参数Key
     * @return 系统参数
     */
    @Override
    @Schema(description = "系统参数")
    @GetExchange(value = "{paramKey}")
    SysParamDTO findParam(@PathVariable String paramKey);

}
