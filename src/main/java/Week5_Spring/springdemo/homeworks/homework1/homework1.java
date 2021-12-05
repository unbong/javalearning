package Week5_Spring.springdemo.homeworks.homework1;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IAspect;
import Week5_Spring.springdemo.homeworks.homework1.Interface.IStudent;
import Week5_Spring.springdemo.homeworks.homework1.aspect.DoHomeWorkActionAspect;
import Week5_Spring.springdemo.homeworks.homework1.aspect.LearningActionAspect;
import Week5_Spring.springdemo.homeworks.homework1.proxy.ProxyFactory;

import java.util.Arrays;
import java.util.List;

public class homework1 {
    public static void main(String[] args) {


        Student student = new Student("unbong", 101);


        IAspect learningAop = new LearningActionAspect("learning");         // learning函数的切面类
        IAspect doHomeWorkAop = new DoHomeWorkActionAspect("doHomeWork");   // doHomeWork函数的切面类

        List<IAspect> aspects = Arrays.asList(learningAop, doHomeWorkAop);
        IStudent student1 = (IStudent) ProxyFactory.getProxyInstance(student, aspects);// 动态代理的实例

        student1.learning("数学");

        System.out.println("+++++++++++++++回家+++++++++++++++");
        student1.doHomeWork();


    }
}
