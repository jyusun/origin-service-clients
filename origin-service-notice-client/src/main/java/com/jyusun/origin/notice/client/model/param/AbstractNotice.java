package com.jyusun.origin.notice.client.model.param;

import com.jyusun.origin.core.common.model.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通知
 *
 * @author jyusun at 20:24:00
 */
@Getter
public abstract class AbstractNotice implements BaseDTO {

    @Schema(description ="发布人")
    private final Serializable publisher;

    @Schema(description ="发布时间")
    private final LocalDateTime publishTime;
    public AbstractNotice() {
        this.publisher = "publisher";
        this.publishTime = LocalDateTime.now();
    }
    public AbstractNotice(Serializable publisher) {
        this.publisher = publisher;
        this.publishTime = LocalDateTime.now();
    }

}
