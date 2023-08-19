package com.jyusun.origin.admin.client.info.model;

import com.jyusun.origin.core.common.model.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据传输对象
 *
 * @author jyusun at2021-12-25 22:50:52
 */
@Data
@Accessors(chain = true)
@Schema(description = "数据传输对象：参数信息")
public class SysParamDTO implements BaseDTO {

    private static final long serialVersionUID = 1L;


}
