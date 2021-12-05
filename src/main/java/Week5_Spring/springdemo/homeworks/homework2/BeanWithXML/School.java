package Week5_Spring.springdemo.homeworks.homework2.BeanWithXML;

import lombok.Data;

import java.util.List;

@Data
public class School {

    private String name;
    private List<Klass>  classes;

    public String getSchoolInfo()
    {
        return "School name is " + name + " have " + classes.size() + " class";
    }



}

