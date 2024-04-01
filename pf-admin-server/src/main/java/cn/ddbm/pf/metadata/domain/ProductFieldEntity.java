package cn.ddbm.pf.metadata.domain;

import lombok.Data;

/**
 * @author wanglin
 * date:
 */
@Data
public class ProductFieldEntity {
    String  id;
    String  productCode;
    String  module;
    String  field;
    String  fieldName;
    String  defaultValue;
    String  memo;
    String  schema;
    Boolean multliSelect;
}
