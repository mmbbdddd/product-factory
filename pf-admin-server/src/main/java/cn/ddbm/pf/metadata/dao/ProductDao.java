package cn.ddbm.pf.metadata.dao;

import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.metadata.domain.ProductEntity;
import cn.ddbm.pf.metadata.domain.ProductSate;

import java.util.List;

/**
 * @author wanglin
 * date:
 */
public interface ProductDao {
    List<ProductEntity> query(Product vo);

    ProductEntity get(Long voId);

    ProductEntity getCurrentProdduct(String code);

    void updateState(Long productId, ProductSate productSate);

    void update(ProductEntity product);
}
