package Week4_Concurreny.Lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo
{
    public String name ;

    public Object u = new Object();
    public LockSupportDemo(String name){
        this.name = name;
    }
    public void runDemo(){


        synchronized (u)
        {
            System.out.println("in " + name);
            LockSupport.park();
            if(Thread.currentThread().isInterrupted())
            {
                System.out.println(name +"被中断了");
            }


            System.out.println(name +"继续执行");
        }

    }

}


//public class LockSupportDemo {
//
//    public static Object u = new Object();
//    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
//    static ChangeObjectThread t2 = new ChangeObjectThread("t2");
//
//    public static class ChangeObjectThread extends Thread {
//        public ChangeObjectThread(String name) {
//            super(name);
//        }
//        @Override public void run() {
//            synchronized (u) {
//                System.out.println("in " + getName());
//                LockSupport.park();
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println(getName() +"被中断了");
//                }
//                System.out.println(getName() +"继续执行");
//            }
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        t1.start();
//        Thread.sleep(1000L);
//        t2.start();
//        Thread.sleep(3000L);
//        t1.interrupt();
//        LockSupport.unpark(t2);
//        t1.join();
//        t2.join();
//    }
//}