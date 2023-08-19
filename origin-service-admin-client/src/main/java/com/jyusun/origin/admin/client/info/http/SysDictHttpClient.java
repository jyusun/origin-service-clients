package com.jyusun.origin.admin.client.info.http;


import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.admin.client.info.api.SysDictApi;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * <p>
 * 作用描述：字典服务客户端
 * </p>
 *
 * @author jyusun
 * @date 2020/12/16 21:06
 * @since 1.0.0
 */
@Tag(name = "数据字典-HTTP")
@HttpExchange(SysDictApi.API_PREFIX)
public interface SysDictHttpClient extends SysDictApi {

    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return
     */
    @Schema(description = "标签查询：类型键值")
    @PostExchange(value = "{dictCode}/{dictValue}")
    DictDTO findDict(@PathVariable String dictCode, @PathVariable Object dictValue);


    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return
     */
    @Schema(description = "标签查询：类型键值")
    @GetExchange(value = "desc/{dictCode}/{dictValue}")
    String findDesc(@PathVariable String dictCode, @PathVariable Object dictValue);

    /**
     * 查询字典项集合
     *
     * @param dictCode {@code String} 类型编号
     * @return
     */
    @Schema(description = "字典集合：字典编号")
    @GetExchange(value = "{dictCode}")
    List<DictDTO> findItems(@PathVariable String dictCode);


}
