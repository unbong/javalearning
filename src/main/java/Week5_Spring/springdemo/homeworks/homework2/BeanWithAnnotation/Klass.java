package Week5_Spring.springdemo.homeworks.homework2.BeanWithAnnotation;

import Week5_Spring.springdemo.homeworks.homework2.BeanWithXML.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Data
@Component("class")
public class Klass {

    private String name;
    @Resource(name= "student1")
    private List<Student> students;

    public String getClassInfo()
    {
        return "Class name is " + name + " have " + students.size() + " students.";
    }



}
