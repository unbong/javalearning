package Week4_Concurreny.homework;


/**
 *  使用 join 方法实现等待
 *
 */
public class WorkWithJoin {

    private String value = "";

    public void doWork()
    {
        value = "work done.";
    }


    public String getValue()
    {
        return value;
    }


    public static void main(String[] args) throws InterruptedException {

        WorkWithJoin w1 = new WorkWithJoin();
        Thread t1 = new Thread(()->{
            w1.doWork();
        });
        t1.start();
        t1.join();

        System.out.println(w1.getValue());
    }
}
