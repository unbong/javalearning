package Week5_Spring.springdemo.homeworks.homework2.BeanWithXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 *  使用XML的方式 xml的定义为applicationContext.xml
 *
 */
public class HomeworkWithXML {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("学校信息================");
        School school = context.getBean(School.class);

        System.out.println(school.getSchoolInfo());

        List<Klass> classes = school.getClasses();

        System.out.println("班级信息================");
        for (Klass item :
                classes) {
            System.out.println(item.getClassInfo());

            System.out.println("学员信息================");

            for (Student student : item.getStudents()) {
                System.out.println(student.toString());
            }
        }
    }
}
