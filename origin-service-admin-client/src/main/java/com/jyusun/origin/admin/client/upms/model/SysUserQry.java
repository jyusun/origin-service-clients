package com.jyusun.origin.admin.client.upms.model;

import com.jyusun.origin.core.common.model.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 查询对象
 *
 * @author jyusun at 2022-06-10 23:34:40
 */
@Data
@Accessors(chain = true)
@Schema(description = "查询对象：用户账户")
public class SysUserQry implements BaseQuery {
}
