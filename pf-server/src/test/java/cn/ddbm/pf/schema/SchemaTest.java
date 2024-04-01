package cn.ddbm.pf.schema;


import cn.ddbm.pf.sdk.PFClient;
import cn.ddbm.pf.sdk.PFRequest;
import org.junit.Test;

public class SchemaTest {

    @Test
    public void test() {
//        for(int i = 0;i<100;i++) {
        for(;;) {
            PFClient.get(new PFRequest("testDomain", "testCode", 1));
        }
    }



}