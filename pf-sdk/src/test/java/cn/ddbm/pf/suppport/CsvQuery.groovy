package cn.ddbm.pf.suppport;

import cn.ddbm.pf.dto.ModuleAttribute;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author wanglin
 * date:
 */
@Component
public class CsvQuery implements InitializingBean {


    private Connection connection;

    NamedParameterJdbcTemplate jdbcTemplate;

    List<ModuleAttribute> listAll(String table) {
        String listModule = "select * from product_module";
        String listFields = "select * from product_field_schema";
        List<Map<String, Object>> fields = jdbcTemplate.queryForList(listFields, new HashMap<String, Object>())
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connection = DriverManager.getConnection("jdbc:xbib:csv:D:\\projects\\product-factory\\doc\\db\\");
        System.setProperty("line.separator", "\n"); // used by PrintStream/BufferedWriter

        jdbcTemplate = new NamedParameterJdbcTemplate(new SingleConnectionDataSource(connection, true))
    }


}
