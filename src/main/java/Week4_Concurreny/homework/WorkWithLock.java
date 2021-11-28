package Week4_Concurreny.homework;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Lock实现主线程阻塞，等待子线程结果。
 *
 */

public class WorkWithLock {

    static ReentrantLock lock = new ReentrantLock(true);
    static Integer result ;
    private static   int sum() {
        return fibo(36);
    }

    private  static  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                result = WorkWithLock.sum();
            }
            finally {
                lock.unlock();
            }
        });


        t1.start();
        Thread.sleep(1);
        try{
            lock.lock();
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        }
        finally {
            lock.unlock();
        }


    }
}
