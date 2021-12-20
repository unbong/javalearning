package Week6_Mysql.java8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Ssl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


@Slf4j
public class GenericDemo implements Serializable {

    public static void main(String[] args) {


        Demo demo = new Demo();

        Class clazz = demo.getClass();
        System.out.println(clazz.getSuperclass());

        Type type = clazz.getGenericSuperclass();
        System.out.println(type);

        ParameterizedType p = (ParameterizedType)type;
        System.out.println(p);
        Class c = (Class)p.getActualTypeArguments()[0];

        System.out.println(c);

    }

    public static class Person<T extends Serializable>
    {

    }

    public static class Demo extends Person<GenericDemo>
    {

    }
}
