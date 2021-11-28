package Week4_Concurreny.homework;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Lock实现主线程阻塞，等待子线程结果。
 *
 */

public class WorkWithLock {

    ReentrantLock lock = new ReentrantLock(true);
    private String value = "";

    public void doWork()
    {
        lock.lock();
        value = "work done.";
        lock.unlock();
    }


    public String getValue()
    {
        try {
            lock.lock();
            return value;
        }finally {

            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        WorkWithLock worker = new WorkWithLock();
        Thread t1 = new Thread(()->{
            worker.doWork();
        });


        t1.start();
        Thread.sleep(1);

        System.out.println(worker.getValue());
    }
}
