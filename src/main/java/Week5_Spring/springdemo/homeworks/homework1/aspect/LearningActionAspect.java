package Week5_Spring.springdemo.homeworks.homework1.aspect;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IAspect;

public class LearningActionAspect implements IAspect {

    private String methodName;

    public LearningActionAspect(String methodName)
    {
        this.methodName = methodName;
    }

    @Override
    public void preAction() {
        System.out.println("学习前做预习。");
    }

    @Override
    public void postAction()
    {
        System.out.println("学习完准备做作业。");
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }
}
