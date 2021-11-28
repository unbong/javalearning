package Week4_Concurreny.homework;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport实现主线程等待，等待子线程结果。
 *
 */

public class WorkWithLockSupport {



    private String value = "";

    public void doWork()
    {
        value = "work done.";
    }


    public String getValue()
    {
        return value;
    }

    public static void main(String[] args) {

        WorkWithLockSupport work = new WorkWithLockSupport();
        Thread main = Thread.currentThread();
        Thread t1 = new Thread(
                ()->{
                    try {
                        Thread.sleep(1000l);
                        work.doWork();
                        LockSupport.unpark(main);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
        );

        t1.start();
        LockSupport.park();

        System.out.println(work.getValue());

    }






}
