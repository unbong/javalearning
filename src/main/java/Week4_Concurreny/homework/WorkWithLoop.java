package Week4_Concurreny.homework;
/**
 * 令主线程在循环中等待子线程结果。
 *
 */

public class WorkWithLoop {


    private volatile  boolean done = false;
    private String value = "";

    public void doWork()
    {
        value = "work done.";
    }

    public String getValue()
    {
        return value;
    }

    public boolean isDone() {
        return done;
    }




    public static void main(String[] args) throws InterruptedException {

        WorkWithLoop work = new WorkWithLoop();

        Thread t1 = new Thread(()->{

            work.doWork();
            work.done = true;
        });

        t1.start();
        while(!work.isDone() )
        {
            Thread.sleep(400l);

        }

        System.out.println(work.getValue());

    }
}
