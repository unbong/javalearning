package Week5_Spring.springdemo.homeworks.homework8.Starter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import starter.Entities.School;


/**
 *
 * 将starter的代码 定义在于 spring_starter_demo项目当中
 *
 */
@SpringBootApplication
public class homework8 {

    public static void main(String[] args) {
        SpringApplication.run(homework8.class);
    }

    @Autowired
    School school;

    @Bean
    public void printInfo()
    {
        System.out.println(school.getSchoolInfo());
        System.out.println(school.getClasses().toString());
    }
}
