package Week7_Mysql.homework9.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource firstDataSource()
    {
        log.info("构建主数据源");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource secondDataSource()
    {
        log.info("构建子数据源");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource)
    {
        log.info("构建动态数据源");
        Map<Object, Object> targetDataSource = new HashMap<>(5);
        targetDataSource.put(DataSourceNames.MASTER, firstDataSource);
        targetDataSource.put(DataSourceNames.SLAVE, secondDataSource);

        return new DynamicDataSource(firstDataSource, targetDataSource);
    }
}
