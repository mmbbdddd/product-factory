package cn.ddbm.pf.metadata.service;

import cn.ddbm.pf.api.client.ChangeEventListener;
import cn.ddbm.pf.api.config.ConfigService;
import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.metadata.dao.ProductDao;
import cn.ddbm.pf.metadata.domain.ProductEntity;
import cn.ddbm.pf.metadata.domain.ProductSate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wanglin
 * date:
 */
public class ProductService {

    protected ChangeEventListener changeEventListener;
    protected ConfigService       configService;
    protected ProductDao          productDao;


    //查询草稿
    public List<Product> query(Product vo) {
        return productDao.query(vo).stream().map(ProductEntity::toDto).collect(Collectors.toList());
    }

    //    获取
    public Product get(Long voId) {
        return productDao.get(voId).toDto();
    }

    //    新建
    public Long create(String domain) {
//        return productDao.create(new Product(domain));
        return null;
    }

    //    复制
    public Long copy(Product product) {
        return null;
    }

    //    保存
    public void save(Product product) {
    }

    //    使用
    public void update(Long id, Map<String, Object> defaultvalues) {
    }

    //    发布审批
    void publish0(Product product) {

    }


    //失效审批
    public void invalid0(Long productId) {

    }


    //    审批结果
    public void doPushlish(Long productId) {

//        设置当前产品有效，上一个产品无效，新增版本好
        ProductEntity newProd = productDao.get(productId);
        ProductEntity oldProd = productDao.getCurrentProdduct(newProd.getProductCode());
        newProd.setVersion(oldProd.getVersion() + 1);
        newProd.setState(ProductSate.EFFECT);
        productDao.update(newProd);
        productDao.updateState(oldProd.getId(), ProductSate.INVALID);
//        1，将可发布的字段发布到配置中心
        Product
        configService.publish();
//        2，通知客户端更新
        changeEventListener.onChange(product.toProductModules());
//        3，更新发布状态
        updateStatus(product, ProductSate.EFFECT);
    }

    public void doInvalid(Long productId) {

    }

    public void updateStatus(Product product, ProductSate dcvmStatus) {

    }


}
