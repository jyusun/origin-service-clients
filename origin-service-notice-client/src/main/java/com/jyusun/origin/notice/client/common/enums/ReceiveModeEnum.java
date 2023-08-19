package com.jyusun.origin.notice.client.common.enums;

import com.jyusun.origin.core.common.model.BaseKvEnum;
import lombok.AllArgsConstructor;

/**
 * 接收模式
 *
 * @author jyusun at 2021-10-21 17:15:19
 * @since 1.0.0
 */
@AllArgsConstructor
public enum ReceiveModeEnum implements BaseKvEnum {

    /**
     * 发送模式：
     * 1-用户模式
     * 2-用户分组
     * 3-公司部门
     * 4-模板配置
     * 9-自定义
     */
    UNKNOWN("-1", "未知"),
    USER("1", "用户模式"),
    USER_GROUP("2", "用户分组"),
    USER_DEPT("3", "公司部门"),
    TEMPLATE("4", "模板配置"),
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
     * 描述
     *
     * @return str
     */
    @Override
    public String desc() {
        return this.desc;
    }

}
