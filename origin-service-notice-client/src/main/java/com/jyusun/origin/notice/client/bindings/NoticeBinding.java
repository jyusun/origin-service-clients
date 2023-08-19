package com.jyusun.origin.notice.client.bindings;

import org.springframework.messaging.MessageChannel;

/**
 * 通知
 *
 * @author jyusun at 2022-04-01 18:18:39
 */
public interface NoticeBinding {

    /**
     * Topic 名称
     */
    String OUTPUT = "notice-message-out";

//    @Input(OUTPUT)
    MessageChannel messageChannel();
}
