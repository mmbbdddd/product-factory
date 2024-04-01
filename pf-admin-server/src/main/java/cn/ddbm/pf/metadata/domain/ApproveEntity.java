package cn.ddbm.pf.metadata.domain;

import cn.ddbm.pf.dto.Product;
import lombok.Data;

/**
 * 审批记录表
 *
 * @author wanglin
 * date:
 */
@Data
public class ApproveEntity {
    Long         id;
    Long         productId;
    ApproveEvent event;
    Boolean      result;


}
