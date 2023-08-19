package com.jyusun.origin.admin.client.info.translate;

import com.jyusun.origin.base.translate.TranslateProvider;
import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.admin.client.info.feign.SysDictFeignClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 数据字典处理
 *
 * @author jyusun at 2022-04-14 23:07:21
 */
//@Component
@RequiredArgsConstructor
public class DictTranslateProviderImpl implements TranslateProvider {

    private final SysDictFeignClient systemDictClient;

    /**
     * 值翻译
     *
     * @param dictCode  字典编号
     * @param dictValue 键值
     * @return 数据字典
     */
    @Override
    public DictDTO findDict(String dictCode, Object dictValue) {
        return systemDictClient.findDict(dictCode, String.valueOf(dictValue));
    }

    /**
     * 值翻译
     *
     * @param dictCode 字典编号
     * @return 数据字典
     */
    @Override
    public List<DictDTO> findItems(String dictCode) {
        return systemDictClient.findItems(dictCode);
    }
}
