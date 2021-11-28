package Week4_Concurreny.homework;

import java.util.concurrent.locks.LockSupport;


/**
 * 使用Wait实现主线程等待，等待子线程结果。
 *
 */
public class WorkWithWait {

    private int result ;
    private    int sum() {
        return fibo(36);
    }

    private   int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public int getResult(){ return  result;}

    public static void main(String[] args) throws InterruptedException {
        WorkWithWait work =new WorkWithWait();
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(
                ()->{
                    try {

                        work.result = work.sum();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (work) {
                        work.notifyAll();
                    }



                }, "subthread"
        );

        t1.start();
        synchronized (work)
        {
            work.wait();
        }


        System.out.println("异步计算结果为："+work.result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");


    }



}
