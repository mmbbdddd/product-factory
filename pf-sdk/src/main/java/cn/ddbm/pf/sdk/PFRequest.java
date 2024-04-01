package cn.ddbm.pf.sdk;

import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.dto.ProductModule;
import cn.ddbm.pf.utils.Coasts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PFRequest {
    String       code;
    Integer      version;
    List<String> modules;

    public PFRequest(String code, Integer version, String... modules) {
        this.code    = code;
        this.version = version;
        this.modules = new ArrayList<>();
        this.modules.add(Coasts.BASE_MODULE);
        if (null != modules) {
            this.modules.addAll(Arrays.stream(modules).collect(Collectors.toList()));
        }
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

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }


    public Set<ProductModule> getProductModules() {
        return modules.stream().map(module -> new ProductModule(code, version, module)).collect(Collectors.toSet());
    }

}
