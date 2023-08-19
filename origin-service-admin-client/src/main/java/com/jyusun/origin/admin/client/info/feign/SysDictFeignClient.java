package com.jyusun.origin.admin.client.info.feign;


import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.admin.client.common.constant.SysNameConstant;
import com.jyusun.origin.admin.client.info.api.SysDictApi;
import com.jyusun.origin.admin.client.info.feign.fallback.DictClientFallbackFactory;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
@Tag(name = "数据字典-客户端")
@FeignClient(contextId = "info-dict",value = SysNameConstant.ORIGIN_SYSTEM_INFO, path = SysDictApi.API_PREFIX,
        fallbackFactory =  DictClientFallbackFactory.class)
public interface SysDictFeignClient extends SysDictApi {

    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return
     */
    @Schema(description ="标签查询：类型键值")
    @PostMapping(value = "{dictCode}/{dictValue}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    DictDTO findDict(@PathVariable String dictCode, @PathVariable String dictValue);


    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return
     */
    @Schema(description ="标签查询：类型键值")
    @GetMapping(value = "desc/{dictCode}/{dictValue}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    String findDesc(@PathVariable String dictCode, @PathVariable String dictValue);

    /**
     * 查询字典项集合
     *
     * @param dictCode {@code String} 类型编号
     * @return
     */
    @Schema(description ="字典集合：字典编号")
    @GetMapping(value = "{dictCode}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    List<DictDTO> findItems(@PathVariable String dictCode);


}
