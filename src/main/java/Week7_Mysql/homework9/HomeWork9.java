package Week7_Mysql.homework9;


import Week7_Mysql.homework9.datasource.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
@MapperScan("Week7_Mysql.homework9.mapper")
//@SpringBootApplication
public class HomeWork9 {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork9.class, args);
    }
}
