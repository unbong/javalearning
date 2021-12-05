package Week5_Spring.springdemo.homeworks.homework8.AutoConfig.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ToString
@ConfigurationProperties(prefix = "student")
public class Student {

//    String name  = "defualt";
//    String id = "000000";

    String name  ;
    String id ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
