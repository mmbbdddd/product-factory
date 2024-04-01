package cn.ddbm.pf;

import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.dto.ModuleAttribute;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.api.config.ConfigService
import cn.ddbm.pf.suppport.CsvQuery;
import cn.ddbm.pf.utils.SpringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean

/**
 * @author wanglin
 * date:
 */
@Configurable
public class PFConfig {
    @Bean
    CsvQuery csvQuery() {
        return new CsvQuery();
    }

    @Bean
    SpringUtils springUtils() {
        return new SpringUtils();
    }

    @Bean
    ConfigService remoteConfigRepository() {
        return new ConfigService() {

            @Autowired
            CsvQuery csvQuery;


            @Override
            public void publish(Product product) {

            }

            @Override
            public List<ModuleAttribute> sync(Set<ProductModule> modules) {
                return csvQuery.listAll("product_schema.csv");
            }
        };
    }
}
