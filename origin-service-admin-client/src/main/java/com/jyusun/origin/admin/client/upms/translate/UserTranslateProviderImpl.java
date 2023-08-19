package com.jyusun.origin.admin.client.upms.translate;

import com.google.common.collect.Lists;
import com.jyusun.origin.base.translate.TranslateProvider;
import com.jyusun.origin.core.common.model.DictDTO;
import com.jyusun.origin.admin.client.upms.feign.SysUserFeignClient;
import com.jyusun.origin.admin.client.upms.model.SysUserDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 数据字典处理-用户处理
 *
 * @author jyusun at 2022-04-14 23:07:21
 */
//@Component
@RequiredArgsConstructor
public class UserTranslateProviderImpl implements TranslateProvider {

    private final SysUserFeignClient systemUserFeignClient;

    /**
     * 值翻译
     *
     * @param dictCode  字典编号
     * @param dictValue 键值
     * @return 数据字典
     */
    @Override
    public DictDTO findDict(String dictCode, Object dictValue) {
        SysUserDTO user = systemUserFeignClient.findUserInfo(dictCode);
        return new DictDTO().setDictCode("user")
                            .setDictValue(user.getUsername())
                            .setDictDesc(user.getUsername());
    }

    /**
     * 值翻译
     *
     * @param dictCode 字典编号
     * @return 数据字典
     */
    @Override
    public List<DictDTO> findItems(String dictCode) {
        return Lists.newArrayList();
    }
}
