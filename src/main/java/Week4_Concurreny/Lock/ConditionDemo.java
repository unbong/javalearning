package Week4_Concurreny.Lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private  int Capacity =0;
    public ConditionDemo(int Capacity)
    {
        this.Capacity = Capacity;
    }

    private  int counter = 0;
    final Lock lock = new ReentrantLock(true);

    Condition fullCondition = lock.newCondition();
    Condition emptyCondition = lock.newCondition();

    public void put(int putcount ) throws Exception {
        try {
            lock.lock();
            System.out.println(" current: " + this.counter  + "  +++++++ put: " + putcount );
            counter = counter+putcount;

            if( counter == this.Capacity)
            {
                System.out.println("fullCondition.await(); ");
                fullCondition.await();
            }
            else if(counter > this.Capacity)
            {
                counter = counter - putcount;
                //throw new Exception( "Count greater then capacity: "+this.Capacity );
                System.out.println("Count greater then capacity: "+this.Capacity);
            }
            emptyCondition.signalAll();
        }finally {
            lock.unlock();

        }

    }

    public void take(int takecount) throws Exception {
        try{
            lock.lock();
            System.out.println(" current: " + this.counter + "  ------- take: " + takecount  );
            counter -= takecount;
            if (counter == 0){
                System.out.println("emptyCondition.await();");
                emptyCondition.await();
            }
            else if(counter < 0)
            {
                counter += takecount;
                //throw new Exception("counter less than 0");
                System.out.println("counter less than 0");
            }
            fullCondition.signalAll();
        }finally {
            lock.unlock();


        }



    }

}
