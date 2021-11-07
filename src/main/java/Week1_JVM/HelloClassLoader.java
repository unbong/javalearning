package Week1_JVM;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 *
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，
 * 执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
 *
 */

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        // read file
        File helloFile = new File("data\\Hello.xlass");
        byte[] bytes = new byte[(int)helloFile.length()];
        InputStream helloStream = new FileInputStream(helloFile);

        int data = 0;
        int index =0;
        while((data = helloStream.read()) != -1){

            bytes[index] = (byte)(255-data);
            index++;
        }

        Class helloClass =  new HelloClassLoader().defineClass("Hello", bytes, 0, bytes.length);

        Object helloObj = helloClass.newInstance();
        Method method = helloClass.getDeclaredMethod("hello");
        method.invoke(helloObj);

    }


}
