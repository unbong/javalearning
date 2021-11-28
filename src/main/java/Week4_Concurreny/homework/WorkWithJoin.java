package Week4_Concurreny.homework;


/**
 *  使用 join 方法实现等待
 *
 */
public class WorkWithJoin {

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
            result= WorkWithJoin.sum();
        });
        t1.start();
        t1.join();

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
