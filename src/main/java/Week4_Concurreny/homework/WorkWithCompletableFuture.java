package Week4_Concurreny.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用CompletableFuture实现主线程阻塞，等待子线程结果。
 *
 */
public class WorkWithCompletableFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "completable future work is done.";
        },es);

        CompletableFuture.allOf( future).get();
        String result =  future.get();

        System.out.println(result);
    }
}
