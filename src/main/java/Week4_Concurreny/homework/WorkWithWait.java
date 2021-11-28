package Week4_Concurreny.homework;

import java.util.concurrent.locks.LockSupport;


/**
 * 使用Wait实现主线程等待，等待子线程结果。
 *
 */
public class WorkWithWait {

    private String value = "";

    public void doWork()
    {
        value = "work done.";
    }


    public String getValue()
    {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        WorkWithWait work =new WorkWithWait();

        Thread t1 = new Thread(
                ()->{
                        work.doWork();
                        work.notifyAll();


                }
        );

        t1.start();
        work.wait();

        System.out.println(work.getValue());


    }



}
