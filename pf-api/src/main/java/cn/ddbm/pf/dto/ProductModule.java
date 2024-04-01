package cn.ddbm.pf.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wanglin
 */
public class ProductModule implements Serializable {
    String  code;
    Integer version;
    String  module;

    public ProductModule(String code, Integer version, String module) {
        this.code    = code;
        this.version = version;
        this.module  = module;
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

    public String getModule() {
        return module;
    }

    public void setModule(String modules) {
        this.module = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModule that = (ProductModule) o;

        if (!Objects.equals(code, that.code)) return false;
        if (!Objects.equals(version, that.version)) return false;
        return Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = version != null ? version.hashCode() : 0;
        result = 31 * result + (module != null ? module.hashCode() : 0);
        return result;
    }

}
