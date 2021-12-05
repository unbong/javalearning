package Week5_Spring.springdemo.spring2;

import Week5_Spring.springdemo.aop.ISchool;
import Week5_Spring.springdemo.spring1.Student;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class School implements ISchool {

    @Autowired(required = true) // primary
    Klass class1;

    @Resource(name="student100")
    Student student100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
