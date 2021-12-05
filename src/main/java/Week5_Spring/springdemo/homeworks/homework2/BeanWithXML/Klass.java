package Week5_Spring.springdemo.homeworks.homework2.BeanWithXML;

import lombok.Data;

import java.util.List;

@Data
public class Klass {

    private String name;
    private List<Student> students;

    public String getClassInfo()
    {
        return "Class name is " + name + " have " + students.size() + " students.";
    }


}
