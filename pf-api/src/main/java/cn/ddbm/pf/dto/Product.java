package cn.ddbm.pf.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wanglin
 * date:
 */
public class Product implements Serializable {
    Long                          id;
    String                        code;
    Integer                       version;
    //module
    Map<String, ProductModule>   modules;
    //module:attribute
    Map<String, ModuleAttribute> fields;

    public Product() {
        this.modules = new HashMap<>();
        this.fields  = new HashMap<>();
    }

    public Product(String code, Integer version) {
        this.code    = code;
        this.version = version;
        this.modules = new HashMap<>();
        this.fields  = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Map<String, ModuleAttribute> getFields() {
        return fields;
    }

    public void setFields(Map<String, ModuleAttribute> fields) {
        this.fields = fields;
    }

    public List<ProductModule> toProductModules() {
        return null;
    }

    public Map<String, ProductModule> getModules() {
        return modules;
    }

    public void setModules(Map<String, ProductModule> modules) {
        this.modules = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(code, product.code)) return false;
        return Objects.equals(version, product.version);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
