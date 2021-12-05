package Week5_Spring.springdemo.homeworks.homework1.proxy;

import Week5_Spring.springdemo.homeworks.homework1.Interface.IAspect;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 动态代理静态工程
 *
 */
public class ProxyFactory {

    /**
     *
     *
     * @param obj       被代理的类
     * @param aspects   切面类
     * @return
     */
    public static Object getProxyInstance(Object obj, List<IAspect> aspects)
    {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.bind(obj, aspects);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),invocationHandler );
    }


}
