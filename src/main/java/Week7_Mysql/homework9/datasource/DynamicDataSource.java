package Week7_Mysql.homework9.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 扩展spring的AbstractRoutingDataSource, 重写determineCurrentLookupKey方法
 *
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource)
    {
        log.info("初始化动态路由数据源");
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }


    @Override
    protected Object determineCurrentLookupKey() {
        log.info("获取数据源的key");
        return getDataSource() ;
    }

    public static void setDataSource(String dataSource)
    {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource()
    {
        return CONTEXT_HOLDER.get();
    }

    public static void clear()
    {
        CONTEXT_HOLDER.remove();
    }
}
