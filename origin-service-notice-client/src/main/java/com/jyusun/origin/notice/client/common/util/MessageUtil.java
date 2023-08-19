package com.jyusun.origin.notice.client.common.util;

import com.jyusun.origin.core.common.util.IdUtil;
import com.jyusun.origin.notice.client.common.enums.SendStatusEnum;
import lombok.experimental.UtilityClass;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 消息工具
 *
 * @author jyusun at 2022-04-01 20:49:43
 */
@UtilityClass
public class MessageUtil {

    public static <T> Message<T> createMessage(T payload, String output, int maxSendRetry, Boolean persist) {
        return MessageBuilder.withPayload(payload)
                .setHeader("x-payload-type", payload.getClass().getCanonicalName())
                .setHeader("x-original-id", IdUtil.genSnowFlake())
                    .setHeader("x-output", output)
                .setHeader("x-max-send-retry", maxSendRetry)
                .setHeader("x-send-retry", 0)
                // 持久化
                .setHeader("x-persist", persist)
                .setHeader("x-status-code", SendStatusEnum.TO_SEND.code())
                // Rabbit 手动确认
                .setHeader("x-manual-com.jyusun.origin.base.translate.handle", false)
                .build();
    }

}
