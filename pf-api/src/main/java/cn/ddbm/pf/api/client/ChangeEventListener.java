package cn.ddbm.pf.api.client;


import cn.ddbm.pf.dto.ProductModule;

import java.util.List;

public interface ChangeEventListener {
    void onChange(List<ProductModule> events);
}
