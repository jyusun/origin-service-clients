package com.jyusun.origin.notice.client.model.param;

import com.google.common.collect.Lists;
import com.jyusun.origin.notice.client.common.enums.PushModeEnum;
import com.jyusun.origin.notice.client.common.enums.ReceiveModeEnum;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * 站内通知
 *
 * @author jyusun at 2022-04-16 10:44:55
 */
@Getter
public class StationNotice extends AbstractNotice {


    /**
     * 推送模式
     */
    private final String pushMode;

    /**
     * 接收处理模式：
     * 1-用户模式
     * 2-用户分组
     * 3-公司部门
     * 4-模板配置
     * 9-自定义
     */
    private final String receiveMode;

    /**
     * 根据模式定义为不同的主键编号
     */
    private final List<Serializable> ids;

    public StationNotice(PushModeEnum pushMode, ReceiveModeEnum receiveMode, List<Serializable> ids,
                         Serializable publisher) {
        super(publisher);
        this.pushMode = pushMode.code();
        this.receiveMode = receiveMode.code();
        this.ids = ids;
    }

    public static StationNoticeBuilder builder() {
        return new StationNoticeBuilder();
    }

    public static class StationNoticeBuilder {

        /**
         * 根据模式定义为不同的主键编号
         */
        private final List<Serializable> ids = Lists.newArrayList();

        /**
         * 消息发布人
         */
        private Serializable publisher;

        public StationNoticeBuilder ids(List<Serializable> ids) {
            this.ids.addAll(ids);
            return this;
        }

        public StationNoticeBuilder addId(Serializable sid) {
            this.ids.add(sid);
            return this;
        }

        public StationNoticeBuilder publisher(Serializable publisher) {
            this.publisher = publisher;
            return this;
        }

        public StationNotice build(PushModeEnum pushMode, ReceiveModeEnum receiveMode) {
            return new StationNotice(pushMode, receiveMode, ids, publisher);
        }
    }
}
