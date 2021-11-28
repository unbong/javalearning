package Week4_Concurreny.homework;

import java.util.concurrent.*;


/**
 * 使用Future实现主线程阻塞，等待子线程结果。
 *
 */
public class WorkWIthFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es =  Executors.newFixedThreadPool(2);

        Future<String> future = es.submit(()->{

            return "future work is done. ";
        });

        String res = future.get();

        System.out.println(res);
        es.shutdown();

    }
}
