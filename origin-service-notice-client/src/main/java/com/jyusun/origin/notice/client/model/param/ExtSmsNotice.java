package com.jyusun.origin.notice.client.model.param;

import com.google.common.collect.Lists;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

/**
 * 外部短信通知
 *
 * @author jyusun at 2022-04-14 18:15:16
 */
@Getter
public class ExtSmsNotice extends AbstractNotice {

    @Schema(description ="手机号集合")
    private final List<String> extMobiles;

    public ExtSmsNotice(List<String> extMobiles) {
        this.extMobiles = extMobiles;
    }

    public static SmsNoticeBuilder builder() {
        return new SmsNoticeBuilder();
    }

    public static class SmsNoticeBuilder {


        @Schema(description ="手机号集合")
        private final List<String> mobiles = Lists.newArrayList();


        public SmsNoticeBuilder addMobile(String mobile) {
            this.mobiles.add(mobile);
            return this;
        }

        public SmsNoticeBuilder mobiles(List<String> mobiles) {
            this.mobiles.addAll(mobiles);
            return this;
        }

        public ExtSmsNotice build() {
            return new ExtSmsNotice(mobiles);
        }
    }
}
