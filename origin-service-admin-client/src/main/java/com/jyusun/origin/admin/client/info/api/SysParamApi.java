package com.jyusun.origin.admin.client.info.api;

import com.jyusun.origin.core.common.util.StringUtil;
import com.jyusun.origin.admin.client.info.model.SysParamDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "系统参数-客户端")
public interface SysParamApi {

    /**
     * api版本
     */
    String API_VERSION = "api/v1";

    /**
     * API前缀
     */
    String API_PREFIX = API_VERSION + StringUtil.SLASH + "params";


    /**
     * 查询参数
     *
     * @param paramKey {@code String} 参数Key
     * @return 系统参数
     */
    @Operation(summary ="系统参数")
    SysParamDTO findParam(@PathVariable String paramKey);

}
