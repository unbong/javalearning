package Week4_Concurreny.homework;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用BlockingQueue实现主线程阻塞，等待子线程结果。
 *
 */

public class WorkWithBlockingQueue {



    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> data = new ArrayBlockingQueue<>(10, true);


        Thread t1 = new Thread(()->{
            try {
                data.put("woke done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        String value = data.take();
        System.out.println(value);
    }

}
