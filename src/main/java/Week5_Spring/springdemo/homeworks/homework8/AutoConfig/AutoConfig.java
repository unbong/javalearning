package Week5_Spring.springdemo.homeworks.homework8.AutoConfig;

import Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities.Klass;
import Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities.School;
import Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/**
 * 自动配置类，将配置属性与需要被配置的类通过@Bean的方式提供
 * 此自动配置类，需要设定到META-INF文件夹下的spring.factories的自动配置的设定当中
 * @Configuration
 * @EnableConfigurationProperties注解是将配置属性类导入进自动配置当中。
 *
 */
@Configuration
@EnableConfigurationProperties(Student.class)
public class AutoConfig {


    private Student student;

    @Autowired
    private Klass klass;


    private School school  ;

    @Bean
    public School configSchol()
    {
        school = new School();
        klass.setName("class1th");
        klass.setStudents(Arrays.asList(student));
        school.setName("school 1th ");
        school.setClasses(Arrays.asList(klass));

        return school;
    }

}
