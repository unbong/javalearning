package Week4_Concurreny.homework;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用BlockingQueue实现主线程阻塞，等待子线程结果。
 *
 */

public class WorkWithBlockingQueue {

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
        ArrayBlockingQueue<Integer> data = new ArrayBlockingQueue<>(10, true);


        Thread t1 = new Thread(()->{
            try {
                data.put(WorkWithBlockingQueue.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        Integer result = data.take();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

}
