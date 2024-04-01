package cn.ddbm.pf.sdk;

import cn.ddbm.pf.api.client.ChangeEventListener;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.sdk.repository.LocalConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 *
 * 客户端的服务，等待服务器端广播
 * @author wanglin
 *
 */
public class ClientChangeEventListener implements ChangeEventListener {
    Logger                logger = LoggerFactory.getLogger("pf");
    LocalConfigRepository localConfigRepository;

    @Override
    public void onChange(List<ProductModule> events) {
        try {
            localConfigRepository.syncFromRemoteRepository(events);
        } catch (IOException e) {
            logger.error("同步更新缓存出错", e);
        }
    }
}
