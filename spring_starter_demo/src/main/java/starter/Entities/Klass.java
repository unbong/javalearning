package starter.Entities;

import lombok.Data;

import java.util.List;

@Data
//@Component(value = "class1")
//@Configuration
public class Klass {

    private String name;
    private List<Student> students;

    public String getClassInfo()
    {
        return "Class name is " + name + " have " + students.size() + " students.";
    }

}
