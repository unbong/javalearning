package Week4_Concurreny.homework;
/**
 * 令主线程在循环中等待子线程结果。
 *
 */

public class WorkWithLoop {


    private volatile static boolean done = false;
    static Integer result ;
    private static   int sum() {
        return fibo(36);
    }

    private  static  int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public  static boolean isDone() {
        return done;
    }




    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        Thread t1 = new Thread(()->{

            result = WorkWithLoop.sum();
            WorkWithLoop.done = true;
        });

        t1.start();
        while(!WorkWithLoop.isDone() )
        {
            Thread.sleep(10l);

        }

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }
}
