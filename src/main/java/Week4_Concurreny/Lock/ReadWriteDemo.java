package Week4_Concurreny.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo {


    private final Map<String, Object> map = new HashMap<>();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public Object readObject(String key)
    {
        Object value = null;

        System.out.println("1 首先开启读锁去缓存中取数据");

        readWriteLock.readLock().lock();

        try{
            value = map.get(key);

            if(value == null)
            {
                System.out.println("2 数据不存在，则释放读锁，开启写锁");
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try{
                    if(value == null)
                    {
                        value = "aaa";
                    }
                }
                finally {
                    System.out.println("3 释放写锁");
                    readWriteLock.writeLock().unlock();
                }
                System.out.println("4 开启读锁");
                readWriteLock.readLock().lock();
            }
        }
        finally {
            System.out.println("5. 释放读锁");
            readWriteLock.readLock().unlock();
        }

        return value;
    }

}
