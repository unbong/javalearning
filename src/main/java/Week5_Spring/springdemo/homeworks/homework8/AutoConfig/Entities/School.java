package Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities;

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

