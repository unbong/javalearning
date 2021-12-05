package Week5_Spring.springdemo.homeworks.homework1.aspect;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IAspect;

public class DoHomeWorkActionAspect implements IAspect {

    private String methodName; // 切点函数名


    @Override
    public String getMethodName()
    {
        return  methodName;
    }
    public DoHomeWorkActionAspect(String methodName)
    {
        this.methodName = methodName;
    }

    /**
     * 前置处理
     *
     */
    @Override
    public void preAction() {
        System.out.println("做作业前复习。");
    }

    /**
     * 后置处理
     *
     */
    @Override
    public void postAction()
    {
        System.out.println("作业检查。");
    }
}
