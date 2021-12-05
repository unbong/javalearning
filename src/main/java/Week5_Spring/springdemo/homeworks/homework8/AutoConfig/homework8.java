package Week5_Spring.springdemo.homeworks.homework8.AutoConfig;

import Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities.School;
import Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class homework8 {

    public static void main(String[] args) {
        SpringApplication.run(homework8.class);
    }

    @Autowired
    Student student;

    @Autowired
    School school;

    @Bean
    public void printInfo()
    {
        System.out.println(student.toString());
        System.out.println(school.getSchoolInfo());
    }
}
