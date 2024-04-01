package cn.ddbm.pf.metadata.domain;

/**
 * @author wanglin
 * date:
 */
public enum ProductSate {
    DRAFT("草稿态"),
    EFFECT0("可发布"),
    EFFECT("已发布"),
    INVALID0("待失效"),
    INVALID("已失效");

    private final String desc;

    ProductSate(String desc) {
        this.desc = desc;
    }
}
