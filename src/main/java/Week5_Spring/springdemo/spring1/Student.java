package Week5_Spring.springdemo.spring1;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


import java.io.Serializable;

@Data
@ToString
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {

    private int id;
    private String name ;
    private String beanName;
    private ApplicationContext applicationContext  ;

    public Student()
    {
        System.out.println("无参构造器--------");
    }

    public Student(int id , String name, String beanName, ApplicationContext applicationContext  ){
        System.out.println("有参参构造器--------id： "+ id  + " name: " + name);
        this.id = id;
        this.name = name;
        this.beanName = beanName;
        this.applicationContext = applicationContext;
    }




    public void init(){
        System.out.println("hello-.................");
    }

    public static Student create()
    {
        return  new Student(102, "unbong", null, null);

    }

    public void print()
    {
        System.out.println(this.beanName);
        System.out.println("context.getBeanDefinitionNames() ===>> "
            + String.join("," + applicationContext.getBeanDefinitionNames()));
    }
}
