package cn.ddbm.pf.sdk;

import cn.ddbm.pf.dto.Product;
import cn.ddbm.pf.PFConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanglin
 * date:
 */
public class PFClientTest {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();


    @Test
    public void test() {
        ctx.register(PFConfig.class);
        ctx.refresh();
        Product response = PFClient.get(new PFRequest("test",1));
    }

}