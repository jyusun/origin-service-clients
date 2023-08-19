package com.jyusun.origin.notice.client.common.enums;

import com.jyusun.origin.core.common.model.BaseKvEnum;
import lombok.AllArgsConstructor;

/**
 * 推送模式
 *
 * @author jyusun at 2021-10-21 17:15:19
 * @since 1.0.0
 */
@AllArgsConstructor
public enum PushModeEnum implements BaseKvEnum {

    /**
     * 发送模式：
     * 1-站内推送
     * 2-邮件推送
     * 3-短信推送
     */
    UNKNOWN("-1", "未知"),
    STATION("1", "站内推送"),
    SMS("2", "短信推送"),
    MAIL("3", "邮件推送");


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

}
