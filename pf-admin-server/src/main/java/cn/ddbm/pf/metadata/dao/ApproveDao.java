package cn.ddbm.pf.metadata.dao;

import cn.ddbm.pf.metadata.domain.ApproveEntity;

/**
 * @author wanglin
 * date:
 */
public interface ApproveDao {
    ApproveEntity get(Long approveId);

    void save(ApproveEntity approve);
}
