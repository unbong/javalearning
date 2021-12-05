package starter.Entities;

import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ToString
@ConfigurationProperties(prefix = "student2")
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
