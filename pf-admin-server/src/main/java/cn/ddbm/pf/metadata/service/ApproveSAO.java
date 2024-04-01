package cn.ddbm.pf.metadata.service;

import cn.ddbm.pf.metadata.dao.ApproveDao;
import cn.ddbm.pf.metadata.domain.ApproveEntity;
import cn.ddbm.pf.metadata.domain.ApproveEvent;
import org.apache.commons.lang3.tuple.Triple;

/**
 * @author wanglin
 * 1，审批Service
 * 2，审批SAO
 */

public class ApproveSAO {
    ProductService metadataService;
    protected ApproveDao approveDao;

    //    提交申请（发布/失效）
    public void approve(ApproveEntity request) {

    }


    //    审批结果
    public void onResult(Object result) {
//        解析结果
        Triple<Long, ApproveEvent, Boolean> triple  = resolveResult(result);
        ApproveEntity                       approve = approveDao.get(triple.getLeft());
//        更新申请单状态
        updateApprove(approve, triple.getRight());
//        发布产品
        if (triple.getRight()) {
            if (triple.getMiddle().equals(ApproveEvent.PUBLISH)) {
                metadataService.doPushlish(approve.getProductId());
            }else{
                metadataService.doInvalid(approve.getProductId());
            }
        }
    }

    private void updateApprove(ApproveEntity approve, Boolean result) {
        approve.setResult(result);
    }

    private Triple<Long, ApproveEvent, Boolean> resolveResult(Object result) {
        return null;
    }


}
