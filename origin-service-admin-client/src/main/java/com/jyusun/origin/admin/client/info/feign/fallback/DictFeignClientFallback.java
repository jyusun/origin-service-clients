package com.jyusun.origin.admin.client.info.feign.fallback;

import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.admin.client.info.feign.SysDictFeignClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 字典服务降级
 *
 * @author jyusun
 */
@Slf4j
public class DictFeignClientFallback implements SysDictFeignClient {

    @Setter
    private Throwable cause;

    public DictFeignClientFallback(Throwable throwable) {
        this.cause = throwable;
    }

    /**
     * 查询字典标签
     *
     * @param dictCode  {@code String} 类型编号
     * @param dictValue {@code String} 字典键值
     * @return DictDTO
     */
    @Override
    public DictDTO findDict(String dictCode, String dictValue) {
        return null;
    }

    @Override
    public String findDesc(String dictCode, String dictValue) {
        return null;
    }

    @Override
    public List<DictDTO> findItems(String dictCode) {
        return null;
    }
}
