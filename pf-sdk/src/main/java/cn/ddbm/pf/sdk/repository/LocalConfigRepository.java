package cn.ddbm.pf.sdk.repository;

import cn.ddbm.pf.PFConfiguration;
import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.dto.ModuleAttribute;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.api.config.ConfigService;
import cn.ddbm.pf.sdk.PFRequest;
import cn.ddbm.pf.utils.PFUtils;
import cn.ddbm.pf.utils.SpringUtils;
import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalConfigRepository {
    Logger                         logger = LoggerFactory.getLogger("pf");
    //product_code:version:module:field:schema
    Cache<String, ModuleAttribute> fieldCache;
    //product_code:version:module
    Cache<String, ProductModule>   moduleCache;

    ConfigService remoteConfigRepository;


    public LocalConfigRepository(PFConfiguration configuration) {
        fieldCache  = configuration.getFieldCache();
        moduleCache = configuration.getModuleCache();
    }


    /**
     * 1,从缓存获取
     * 2,从远程同步
     *
     * @param request
     * @return
     */
    public Product get(PFRequest request) {
        //判断缓存是否有
        if (cacheExist(request)) {
            //从缓存获取
            return getFromCache(request);
        } else {
            try {
                //从远程获取
                syncFromRemoteRepository(new ArrayList<>(request.getProductModules()));
                return getFromCache(request);
            } catch (IOException e) {
                //获取异常，排给应用去处理
                throw new RuntimeException("同步异常:" + e.getMessage());
            }
        }
    }

    private boolean cacheExist(PFRequest request) {
        String  code    = request.getCode();
        Integer version = request.getVersion();
        for (String module : request.getModules()) {
            String key = PFUtils.fieldKey(code, version, module);
            if (!fieldCache.containsKey(key)) {
                return false;
            }
        }
        return true;
    }

    private Product getFromCache(PFRequest request) {
        Product product = new Product(request.getCode(), request.getVersion());
        for (ProductModule m : request.getProductModules()) {
            String          productCode     = m.getCode();
            Integer         version         = m.getVersion();
            String          module          = m.getModule();
            String          fieldKey        = PFUtils.fieldKey(productCode, version, module);
            ModuleAttribute moduleAttribute = fieldCache.get(fieldKey);
            if (null != moduleAttribute) {
                product.getFields().put(module, moduleAttribute);
            } else {
                logger.warn("[{}]缓存配置不存在，请确认请求/配置中心是否正确", fieldKey);
            }
        }
        return product;
    }


    public void syncFromRemoteRepository(List<ProductModule> modules) throws IOException {
        //排除本地缓存中已有的
        Set<ProductModule> exclusionCacheModules = modules.stream().filter(m -> !fieldCache.containsKey(PFUtils.fieldKey(m.getCode(), m.getVersion(), m.getModule()))).collect(Collectors.toSet());
        //从远程同步
        List<ModuleAttribute> syncModules = getRemoteConfigRepository().sync(exclusionCacheModules);
        syncModules.forEach(m -> {
            String  productCode = m.getModule().getCode();
            String  module      = m.getModule().getModule();
            Integer version     = m.getModule().getVersion();
            String  fieldKey    = PFUtils.fieldKey(productCode, version, module);
            fieldCache.remove(fieldKey);
            fieldCache.put(fieldKey, m);
        });
    }

    private ConfigService getRemoteConfigRepository() {
        if (null == this.remoteConfigRepository) {
            synchronized (LocalConfigRepository.class) {
                remoteConfigRepository = SpringUtils.getBean(ConfigService.class);
            }
        }
        return remoteConfigRepository;
    }
}
