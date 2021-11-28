package Week4_Concurreny.homework;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport实现主线程等待，等待子线程结果。
 *
 */

public class WorkWithLockSupport {



    static Integer result ;
    private static   int sum() {
        return fibo(36);
    }

    private  static  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        Thread main = Thread.currentThread();
        Thread t1 = new Thread(
                ()->{
                    try {
                        //Thread.sleep(1000l);
                        result = WorkWithLockSupport.sum();
                        LockSupport.unpark(main);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
        );

        t1.start();
        LockSupport.park();

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }






}
