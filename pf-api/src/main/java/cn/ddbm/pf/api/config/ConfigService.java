package cn.ddbm.pf.api.config;

import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.dto.ModuleAttribute;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author wanglin
 * date:
 */
public interface ConfigService {
    void publish(Product product);

    /**
     * @param request domain:code:version
     * @return field:schema
     */
    List<ModuleAttribute> sync(Set<ProductModule> request) throws IOException;
}
