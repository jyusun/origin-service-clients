package com.jyusun.origin.notice.client.common.enums;

import com.jyusun.origin.core.common.model.BaseKvEnum;
import com.jyusun.origin.core.common.util.StringUtil;
import lombok.AllArgsConstructor;

/**
 * 消息类型
 *
 * @author jyusun at 2021-10-21 17:15:19
 * @since 1.0.0
 */
@AllArgsConstructor
public enum ContentTypeEnum implements BaseKvEnum {

    /**
     * 通知类型:-1-未知|1-系统公告|2-系统通知|3-私信|4验证码|9-自定义
     */
    UNKNOWN("-1", "未知"),
    BULLETIN("1", "系统公告"),
    NOTICE("2", "系统通知"),
    CHAT("3", "私信"),
    CUSTOM("9", "自定义");

    private final String code;
    private final String desc;


    /**
     * 值
     *
     * @return str
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * 标签
     *
     * @return str
     */
    @Override
    public String desc() {
        return this.desc;
    }

    public static ContentTypeEnum getEnum(String code) {
        for (ContentTypeEnum typeEnum : ContentTypeEnum.values()) {
            if (StringUtil.pathEquals(typeEnum.code, code)) {
                return typeEnum;
            }
        }
        return UNKNOWN;
    }
}
