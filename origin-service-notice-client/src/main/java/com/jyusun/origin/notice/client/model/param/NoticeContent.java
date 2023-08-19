package com.jyusun.origin.notice.client.model.param;

import com.google.common.collect.Lists;
import com.jyusun.origin.core.common.model.BaseDTO;
import com.jyusun.origin.core.common.util.StringUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 数据传输对象
 * <p>
 * 作用描述：消息通知
 *
 * @author jyusun at 2022/3/29 11:29
 * @since 1.0.0
 */
@Getter
@ToString
@Accessors(chain = true)
@Schema(description = "数据传输对象：消息通知")
public class NoticeContent implements BaseDTO {


    @Schema(description ="消息类型")
    private final String type;

    @Schema(description ="标题")
    @NotBlank(message = "不允许为空")
    private final String subject;

    @Schema(description ="内容")
    @NotBlank(message = "不允许为空")
    private final String content;

    @Schema(description ="附件编号集合")
    private final List<String> attachmentIds;

    /**
     * 重定向地址
     */
    @Schema(description ="重定向地址")
    private final String redirectUri;


    public NoticeContent(String subject, String content, String type, List<String> attachmentIds,
                         String redirectUri) {
        this.subject = subject;
        this.content = content;
        this.type = type;
        this.attachmentIds = attachmentIds;
        this.redirectUri = redirectUri;

    }


    public NoticeContent(String subject, String content, String type) {
        this.subject = subject;
        this.content = content;
        this.type = type;
        this.attachmentIds = Lists.newArrayList();
        this.redirectUri = StringUtil.EMPTY;

    }

}
