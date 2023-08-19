package com.jyusun.origin.notice.client;

import com.jyusun.origin.notice.client.model.NoticeDTO;
import com.jyusun.origin.notice.client.common.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

/**
 * 消息通知
 *
 * @author jyusun at 2022-04-01 22:03:50
 */
@RequiredArgsConstructor
public class NoticeClient {

    private final StreamBridge streamBridge;

    /**
     * 发送消息通知
     */
    public void send(NoticeDTO noticeDTO) {
        this.streamBridge.send("","", MessageUtil.createMessage(noticeDTO, "", 3, false));
    }

}
