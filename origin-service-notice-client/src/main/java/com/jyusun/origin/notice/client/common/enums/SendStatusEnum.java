package com.jyusun.origin.notice.client.common.enums;

import com.jyusun.origin.core.common.model.BaseKvEnum;
import lombok.AllArgsConstructor;

/**
 * 消息发送状态
 *
 * @author jyusun at 2022-04-09 22:14:39
 */
@AllArgsConstructor
public enum SendStatusEnum implements BaseKvEnum {

    /**
     * 消息发送状态：1-未知|1-待发送|2-发送失败|3-处理完成|4-处理失败|5已忽略
     */
    UNKNOWN("-1", "未知"),
    TO_SEND("1", "待发送"),
    FAILED("2", "发送失败"),
    HANDLE_SUCCESS("3", "处理完成"),
    HANDLE_FAILED("4", "处理失败"),
    IGNORE("5", "已忽略");

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
