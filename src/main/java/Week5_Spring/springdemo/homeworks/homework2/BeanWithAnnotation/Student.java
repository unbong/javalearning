package Week5_Spring.springdemo.homeworks.homework2.BeanWithAnnotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Component("student1")
@Primary
public class Student {

    String name;
    String id;

}
