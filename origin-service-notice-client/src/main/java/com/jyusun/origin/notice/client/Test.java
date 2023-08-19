package com.jyusun.origin.notice.client;

import com.google.common.collect.Maps;
import com.jyusun.origin.notice.client.model.NoticeDTO;
import com.jyusun.origin.notice.client.model.param.AbstractNotice;
import com.jyusun.origin.notice.client.model.param.ExtSmsNotice;
import com.jyusun.origin.notice.client.model.param.StationNotice;
import com.jyusun.origin.notice.client.common.enums.ContentTypeEnum;
import com.jyusun.origin.notice.client.common.enums.PushModeEnum;
import com.jyusun.origin.notice.client.common.enums.ReceiveModeEnum;
import com.jyusun.origin.notice.client.common.util.MessageUtil;
import com.jyusun.origin.notice.client.model.param.ExtMailNotice;
import com.jyusun.origin.notice.client.model.param.TemplateNotice;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 通知消息
 */
@Component
@RequiredArgsConstructor
public class Test {
    private final StreamBridge streamBridge;

    public void test() {

        AbstractNotice extSmsNotice = ExtSmsNotice.builder()
                                                  .addMobile("15677777777")
                                                  .build();

        AbstractNotice extMailNotice = ExtMailNotice.builder()
                .addToaddr("jyusun@foxmail.com")
                .addCcaddr("100001111111@qq.com")
                .build();

        AbstractNotice templateNotice = TemplateNotice.builder()
                .templateId(1L)
                .params(Maps.newHashMap())
                .build();

        AbstractNotice stationNotice = StationNotice.builder()
                                                    .addId(1L)
                                                    .build(PushModeEnum.MAIL, ReceiveModeEnum.USER);

        NoticeDTO noticeDTO = NoticeDTO.builder()
                                       .addNotice(extMailNotice)
                                       .addNotice(extSmsNotice)
                                       .addNotice(templateNotice)
                                       .addNotice(stationNotice)
                                       .message("通知消息", "消息内容啊啊啊", ContentTypeEnum.NOTICE, String.valueOf(1111L))
                                       .build();

        Message<NoticeDTO> message = MessageUtil.createMessage(noticeDTO, "", 1, false);
        streamBridge.send("", "", noticeDTO);
    }
}
