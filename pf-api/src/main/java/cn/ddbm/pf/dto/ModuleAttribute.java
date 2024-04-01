package cn.ddbm.pf.dto;

import cn.ddbm.pf.schema.Schema;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglin
 */
public class ModuleAttribute implements Serializable {
    ProductModule       module;
    Map<String, Schema> attributes;
    public ModuleAttribute(ProductModule module) {
        this.module     = module;
        this.attributes = new HashMap<>();
    }

    public ProductModule getModule() {
        return module;
    }

    public void setModule(ProductModule module) {
        this.module = module;
    }



    public Map<String, Schema> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Schema> attributes) {
        this.attributes = attributes;
    }


}
