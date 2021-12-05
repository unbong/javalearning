package Week5_Spring.springdemo.spring2;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop1 {

    // 前置通知
    public void startTransaction()
    {
        System.out.println("  Aop1 start   ===========> begin ding ...... ");
    }

    // 后置通知
    public void commitTransaction()
    {
        System.out.println(" In Aop1  ===========> finish ding ......    ");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" In Aop1   ===========> around begin ding ......  ");
        joinPoint.proceed();
        System.out.println(" In Aop1   ===========> around finish ding ......  ");
    }

}
