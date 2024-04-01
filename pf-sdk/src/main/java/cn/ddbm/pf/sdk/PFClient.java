package cn.ddbm.pf.sdk;


import cn.ddbm.pf.PFConfiguration;
import cn.ddbm.pf.dto.Product;

public class PFClient {
    static PFConfiguration configuration;

    public static Product get(PFRequest request) {
        return getPFConfiguration().getLocalConfigRepository().get(request);
    }

    private static PFConfiguration getPFConfiguration() {
        if (null != configuration) {
            return configuration;
        } else {
            synchronized (PFConfiguration.class) {
                configuration = PFConfiguration.init();
            }
        }
        return configuration;
    }

}
