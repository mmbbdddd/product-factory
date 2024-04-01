package cn.ddbm.pf;

import cn.ddbm.pf.dto.ModuleAttribute;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.sdk.repository.LocalConfigRepository;
import cn.ddbm.pf.utils.Coasts;
import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

/**
 * @author wanglin
 * date:
 */
public class PFConfiguration {

    LocalConfigRepository localConfigRepository;
    public static PFConfiguration init() {
        return new PFConfiguration(){{
            this.localConfigRepository = new LocalConfigRepository(this);
        }};
    }

    public LocalConfigRepository getLocalConfigRepository() {
        return localConfigRepository;
    }

    public Cache<String, ModuleAttribute> getFieldCache() {
        String cacheLocation = System.getProperty("user.home") + "/" + Coasts.FIELD_CACHE_PATH;
        PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(cacheLocation))
                .withCache(Coasts.FIELD_CACHE_NAME,
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, ModuleAttribute.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder()
                                        .heap(10, MemoryUnit.MB)
                                        .disk(1000, MemoryUnit.MB, true)
                        )
                ).build(true);
        return persistentCacheManager.getCache(Coasts.FIELD_CACHE_NAME, String.class, ModuleAttribute.class);
    }
    public Cache<String, ProductModule> getModuleCache() {
        String cacheLocation = System.getProperty("user.home") + "/" + Coasts.MODULE_CACHE_PATH;
        PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(cacheLocation))
                .withCache(Coasts.MODULE_CACHE_NAME,
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, ProductModule.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder()
                                        .heap(10, MemoryUnit.MB)
                                        .disk(1000, MemoryUnit.MB, true)
                        )
                ).build(true);
        return persistentCacheManager.getCache(Coasts.MODULE_CACHE_NAME, String.class, ProductModule.class);
    }

}
