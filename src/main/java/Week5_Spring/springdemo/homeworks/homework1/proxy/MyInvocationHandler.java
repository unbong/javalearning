package Week5_Spring.springdemo.homeworks.homework1.proxy;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;


/**
 *
 *
 */

public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    private List<IAspect> aspects;

    // 将被代理，切面方法类绑定到访问处理类中
    public void bind(Object obj, List<IAspect> aspects)
    {
        this.obj = obj;
        this.aspects = aspects;
    }

    /**
     *
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        IAspect aspectObj = null;

        // 在被代理类的函数中存在切面类中指定的函数时
        for (IAspect aspect: aspects) {
            if(aspect.getMethodName().equals(method.getName()))
            {
                aspectObj = aspect;
                break;
            }
        }

        if(aspectObj != null) aspectObj.preAction();
        Object result =  method.invoke(obj,args);
        if(aspectObj != null) aspectObj.postAction();

        return result;
    }
}