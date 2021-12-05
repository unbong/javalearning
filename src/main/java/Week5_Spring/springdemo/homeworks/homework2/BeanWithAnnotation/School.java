package Week5_Spring.springdemo.homeworks.homework2.BeanWithAnnotation;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("school")
@Data
@Primary
@NoArgsConstructor
public class School {

    private String name;
    @Autowired
    private List<Klass> classes;

    public String getSchoolInfo()
    {
        return "School name is " + name + " have " + classes.size() + " class";
    }

}
