package Week4_Concurreny;

import Week4_Concurreny.Lock.ConditionDemo;
import Week4_Concurreny.Lock.LockSupportDemo;
import Week4_Concurreny.Lock.ReadWriteDemo;
import Week4_Concurreny.collection.ConcurentHashMap;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class Concurrency {

    public static void main(String[] args) throws InterruptedException {

//        Concurrency.ConditionRunner();
//        Concurrency.LockSupportRunner();

        //Concurrency.readWriteRunner();

        //Concurrency.concurrentMapRunner();


//        Map<String, Integer> mp = new HashMap<>();
//        Map<String, WorkWithXXX> mp = new ConcurrentHashMap<>();
//
//
//        WorkWithXXX i ;
//
//        for (int j = 0; j < 5; j++) {
//            i = mp.get("a");
//            if(i == null)
//            {
//                WorkWithXXX zero = new WorkWithXXX(0);
//
//                i = mp.putIfAbsent("a", zero);
//                if(null ==  i){
//                    i = zero;
//                }
//            }
//            i.add(1);
//        }
//
//        System.out.println(mp);

    }


    /**
     * ConcurrentHashMap 修改
     *
     */
    public static void concurrentMapRunner()
    {
        ConcurentHashMap map = new ConcurentHashMap();
        map.run();
    }


    /**
     * 读写锁测试
     *
     */
    public static void readWriteRunner()
    {
        ReadWriteDemo rd = new ReadWriteDemo();

        ExecutorService es = Executors.newFixedThreadPool(2);


        for (int i = 0; i < 20; i++) {
            final int s = i;
            es.submit(()->{rd.readObject("testdata"+ s); });
        }


        es.shutdown();

    }

    /**
     * LockSupport Demo runner
     *
     * @throws InterruptedException
     */
    public static void LockSupportRunner() throws InterruptedException {
        LockSupportDemo l1 = new LockSupportDemo("l1");
        LockSupportDemo l2 = new LockSupportDemo("l2");

        Thread t1 = new Thread(()->{
            l1.runDemo();
        });

        Thread t2 = new Thread(()->{
            l2.runDemo();
        });

        t1.start();
        Thread.sleep(1000l);
        t2.start();
        Thread.sleep(3000L);
         //t1.interrupt();
        LockSupport.unpark(t1);
//         System.out.println("t1 刚刚给中断");
        LockSupport.unpark(t2);

        t1.join();
        t2.join();


    }


    /**
     * Condition Demo runner
     *
     * @throws InterruptedException
     */
    public static void ConditionRunner() throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo(100);

        Random random = new Random(System.currentTimeMillis());


        Thread putter = new Thread(()->{

            for (int i = 0; i < 10000; i++) {
                try {
                    conditionDemo.put(random.nextInt(100));
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


        });


        Thread takker = new Thread(()->{

            for (int i = 0; i < 10000; i++) {
                try {
                    conditionDemo.take(random.nextInt(100));
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


        });
        putter.start();
        takker.start();

        Thread.sleep(300*1000);

    }
}
