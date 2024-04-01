package cn.ddbm.pf.schema;


import cn.ddbm.pf.PFConfig;
import cn.ddbm.pf.sdk.PFClient;
import cn.ddbm.pf.sdk.PFRequest;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchemaTest {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();


    @Test
    public void test() {
        ctx.register(PFConfig.class);
        ctx.refresh();
//        for(int i = 0;i<100;i++) {
//        for(;;) {
            PFClient.get(new PFRequest(  "testCode", 1));
//        }
    }



}