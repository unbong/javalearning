package Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Klass {

    private String name;
    private List<Student> students;

    public String getClassInfo()
    {
        return "Class name is " + name + " have " + students.size() + " students.";
    }


}
