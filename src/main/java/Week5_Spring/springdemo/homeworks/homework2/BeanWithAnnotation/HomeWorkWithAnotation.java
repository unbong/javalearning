package Week5_Spring.springdemo.homeworks.homework2.BeanWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  使用注解的方式
 */
public class HomeWorkWithAnotation {

    public static void main(String[] args) {


        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContextWithAnnotation.xml");

        School school = context.getBean(School.class);

        System.out.println( school.getSchoolInfo());
    }

}
