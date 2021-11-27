package Week4_Concurreny.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurentHashMap {


    private Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
    private CountDownLatch endLatch = new CountDownLatch(2);
    public void run()
    {
        Runnable task = ()->
        {
            AtomicInteger oldValue ;
            for (int i = 0; i < 10; i++) {
                oldValue = count.get("a");
                System.out.println("in for loop" + i);
                System.out.println(count);
                if(null == oldValue)
                {
                    AtomicInteger zeroValue = new AtomicInteger(0);
                    oldValue  = count.putIfAbsent("a", zeroValue);
                    if (null == oldValue)
                    {
                        oldValue = zeroValue;
                    }
                }
                System.out.println("before increment");
                System.out.println(count);
                oldValue.incrementAndGet();
                System.out.println("after increment");
                System.out.println(count);
            }
            endLatch.countDown();
        };

        new Thread(task).start();
        //new Thread(task).start();

        try
        {
            endLatch.await();

            System.out.println(count);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
