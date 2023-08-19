package com.jyusun.origin.admin.client.info.api;


import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.core.common.util.StringUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
public interface SysDictApi {
    /**
     * api版本
     */
    String API_VERSION = "v1/api";

    /**
     * API前缀
     */
    String API_PREFIX = API_VERSION + StringUtil.SLASH + "dicts";

    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return
     */
    @Operation(summary = "标签查询：类型键值")
    DictDTO findDict(String dictCode, String dictValue);


    /**
     * 查询字典项集合
     *
     * @param dictCode {@code String} 类型编号
     * @return
     */
    @Operation(summary = "字典集合：字典编号")
    List<DictDTO> findItems(String dictCode);


}
