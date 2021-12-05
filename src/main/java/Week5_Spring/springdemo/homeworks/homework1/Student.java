package Week5_Spring.springdemo.homeworks.homework1;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IStudent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements IStudent {


    private String name ;
    private int id;


    @Override
    public void learning(String lessonName) {
        System.out.println(name +"学员正在学习" + lessonName);
    }

    @Override
    public void doHomeWork() {
        System.out.println(name +"学员正在写作业"  );
    }
}
