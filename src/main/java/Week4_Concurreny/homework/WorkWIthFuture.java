package Week4_Concurreny.homework;

import java.util.concurrent.*;


/**
 * 使用Future实现主线程阻塞，等待子线程结果。
 *
 */
public class WorkWIthFuture {

    private static   int sum() {
        return fibo(36);
    }

    private  static  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ExecutorService es =  Executors.newFixedThreadPool(2);

        Future<Integer> future = es.submit(()->{

            return WorkWIthFuture.sum();
        });

        Integer result = future.get();

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        es.shutdown();


    }
}
