package com.jyusun.origin.notice.client.model;

import com.google.common.collect.Lists;
import com.jyusun.origin.core.common.model.BaseDTO;
import com.jyusun.origin.core.common.util.StringUtil;
import com.jyusun.origin.notice.client.model.param.AbstractNotice;
import com.jyusun.origin.notice.client.model.param.NoticeContent;
import com.jyusun.origin.notice.client.common.enums.ContentTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

/**
 * 通知上下文
 *
 * @author jyusun at 2022-04-01 18:39:12
 */
@Getter
public class NoticeDTO implements BaseDTO {

    @Schema(description ="通知方式")
    private final List<AbstractNotice> notices;

    @Schema(description ="消息内容")
    private final NoticeContent noticeContent;

    public NoticeDTO(List<AbstractNotice> notices, NoticeContent noticeContent) {
        this.notices = notices;
        this.noticeContent = noticeContent;
    }

    public static NoticeBuilder builder() {
        return new NoticeBuilder();
    }

    public static class NoticeBuilder {

        @Schema(description ="通知方式")
        private final List<AbstractNotice> notices = Lists.newArrayList();

        @Schema(description ="消息通知")
        private NoticeContent noticeContent;

        /**
         * 添加通知方式
         *
         * @param notice 通知方式
         * @return {@link NoticeBuilder}
         */
        public NoticeBuilder addNotice(AbstractNotice notice) {
            this.notices.add(notice);
            return this;
        }

        public NoticeBuilder message(String subject, String content, String contentType, List<String> attachmentIds,
                                     String redirectUri) {
            this.noticeContent = new NoticeContent(subject, content, contentType, attachmentIds, redirectUri);
            return this;
        }

        public NoticeBuilder message(String title, String content, ContentTypeEnum noticeType,
                                     List<String> attachmentIds, String redirectUri) {
            return this.message(noticeType.code(), title, content, attachmentIds, redirectUri);
        }

        public NoticeBuilder message(String subject, String content, String contentType, String redirectUri) {
            return this.message(subject, content, contentType, Lists.newArrayList(), redirectUri);
        }

        public NoticeBuilder message(String subject, String content, ContentTypeEnum noticeType,
                                     String redirectUri) {
            return this.message(subject, content, noticeType.code(), redirectUri);
        }

        public NoticeBuilder message(String subject, String content, ContentTypeEnum contentType) {
            return this.message(subject, content, contentType, StringUtil.EMPTY);
        }

        public NoticeBuilder message(String title, String content) {
            return this.message(title, content, ContentTypeEnum.BULLETIN, StringUtil.EMPTY);
        }

        public NoticeDTO build() {
            return new NoticeDTO(notices, noticeContent);
        }

    }

}
