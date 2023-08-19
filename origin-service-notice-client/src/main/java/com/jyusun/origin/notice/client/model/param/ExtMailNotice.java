package com.jyusun.origin.notice.client.model.param;

import com.google.common.collect.Lists;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

/**
 * 外部邮件通知
 *
 * @author jyusun at 2022-04-01 20:23:02
 */
@Getter
public class ExtMailNotice extends AbstractNotice {

    /**
     * 收件人
     */
    @Schema(description ="收件人")
    private final List<String> toaddrs;

    /**
     * 抄送人
     */
    @Schema(description ="抄送人")
    private final List<String> ccaddrs;


    public ExtMailNotice(List<String> toaddrs, List<String> ccaddrs) {
        this.toaddrs = toaddrs;
        this.ccaddrs = ccaddrs;
    }

    public static MailNoticeBuilder builder() {
        return new MailNoticeBuilder();
    }

    public static class MailNoticeBuilder {

        /**
         * 收件人
         */
        @Schema(description ="收件人")
        private final List<String> toaddrs = Lists.newArrayList();

        /**
         * 抄送人
         */
        @Schema(description ="抄送人")
        private final List<String> ccaddrs = Lists.newArrayList();

        public MailNoticeBuilder addToaddr(String mailAddr) {
            this.toaddrs.add(mailAddr);
            return this;
        }

        public MailNoticeBuilder addCcaddr(String mailAddr) {
            this.ccaddrs.add(mailAddr);
            return this;
        }

        public ExtMailNotice build() {
            return new ExtMailNotice(toaddrs, ccaddrs);
        }
    }
}
