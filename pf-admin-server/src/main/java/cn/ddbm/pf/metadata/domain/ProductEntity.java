package cn.ddbm.pf.metadata.domain;

import cn.ddbm.pf.dto.Product;
import lombok.Data;

/**
 * @author wanglin
 * date:
 */
@Data
public class ProductEntity {
    Long        id;
    String      productCode;
    Integer     version;
    ProductSate state;
    String      metadataSource;

    public Product toDto() {
        return null;
    }
}
