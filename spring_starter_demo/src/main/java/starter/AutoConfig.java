package starter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import starter.Entities.Klass;
import starter.Entities.School;
import starter.Entities.Student;

import java.util.Arrays;


/**
 *
 *
 */
@Configuration
@EnableConfigurationProperties(Student.class)
public class AutoConfig {


    private Student student;

//    @Autowired
    private Klass klass = new Klass();

    private School school  ;

    @Bean
    public School configSchool()
    {
        System.out.println(student.toString());
        school = new School();
        klass.setName("class1th");
        klass.setStudents(Arrays.asList(student));
        school.setName("school 1th ");
        school.setClasses(Arrays.asList(klass));

        return school;
    }



}
