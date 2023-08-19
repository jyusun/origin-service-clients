package com.jyusun.origin.notice.client.model.param;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

/**
 * 模板通知
 *
 * @author jyusun at 2022-04-16 19:58:21
 */
@Getter
public class TemplateNotice extends AbstractNotice {

    /**
     * 模板编号
     */
    private final Serializable templateId;
    /**
     * 模板参数
     */
    private final Map<String, Object> params;

    public TemplateNotice(Serializable templateId, Map<String, Object> params, Serializable publisher) {
        super(publisher);
        this.templateId = templateId;
        this.params = params;
    }

    public static RuleNoticeBuilder builder() {
        return new RuleNoticeBuilder();
    }

    public static class RuleNoticeBuilder {

        /**
         * 根据模式定义为不同的主键编号
         */
        private Serializable templateId;

        /**
         * 消息发布人
         */
        private Serializable publisher;

        /**
         * 模板解析参数
         */
        private final Map<String, Object> params = Maps.newHashMap();


        public RuleNoticeBuilder templateId(Serializable templateId) {
            this.templateId = templateId;
            return this;
        }

        public RuleNoticeBuilder params(Map<String, Object> params) {
            this.params.putAll(params);
            return this;
        }

        public RuleNoticeBuilder putParam(String key, Object value) {
            this.params.put(key, value);
            return this;
        }

        public RuleNoticeBuilder publisher(Serializable publisher) {
            this.publisher = publisher;
            return this;
        }
        public TemplateNotice build() {
            return new TemplateNotice(templateId, params, publisher);
        }
    }
}
