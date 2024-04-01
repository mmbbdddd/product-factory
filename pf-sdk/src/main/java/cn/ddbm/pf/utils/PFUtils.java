package cn.ddbm.pf.utils;

/**
 * @author wanglin
 * date:PFUtils
 */
public class PFUtils {
    public static String fieldKey(String code, Integer version, String module) {
        return String.format("%s:%s:%s", code, version, module);
    }

    public static String moduleKey(String code, Integer version, String module) {
        return String.format("%s:%s:%s", code, version, module);
    }


}
