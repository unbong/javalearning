package Week7_Mysql.homework3;

import Week5_Spring.springdemo.homeworks.homework10.ConnectPool.CRUDWithHikari;
import Week5_Spring.springdemo.homeworks.homework10.JDBC.CRUDWithJDBC;
import Week5_Spring.springdemo.homeworks.homework10.TransactionPreparedStatement.CRUDWithPrepareStatement;

import java.net.ServerSocket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

public class InsertUseJDBC<main> {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ExecutionException, InterruptedException {

        //useJDBC();

        //usePrepareStatement();

        useConnectionPool();

    }

    public static void useConnectionPool() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("use connection pool insert 1m data。 start time: " + startTime );
        CRUDWithHikari crudWithHikari = new CRUDWithHikari();

        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future> futures = new ArrayList<>();
        //CountDownLatch countDownLatch = new CountDownLatch(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        for (int j =0 ; j < 10 ; j++)
        {
            final int finalJ = j;
            Runnable r = (()->{

                try {
                    cyclicBarrier.await();
                    int startIndex = finalJ * 100000;
                    System.out.println(Thread.currentThread().getName() + " index：" + startIndex );
                    crudWithHikari.createConnection();
                    PreparedStatement preparedStatement =  crudWithHikari.createPreparedStatement("insert into shop.order values (?, 1, 1, 1000, '0', 10, ?,?);");
                    try
                    {
                        for(int i = 1; i <= 100000; i++)
                        {

                            preparedStatement.setInt(1, i + startIndex);

                            preparedStatement.setLong(2, System.currentTimeMillis());
                            preparedStatement.setLong(3, System.currentTimeMillis());
                            //preparedStatement.addBatch();
                            System.out.println(Thread.currentThread().getName() + " index：" + (startIndex  +i) );
                            crudWithHikari.executePrepareUpdate();

                        }
                    }
                    catch (SQLException e)
                    {
                        crudWithHikari.rollback();
                        System.out.println("in catch " + Thread.currentThread().getName() + " index: " + startIndex);
                        throw e;
                    }
                    crudWithHikari.commit();

                    crudWithHikari.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            futures.add(es.submit(r));
        }

        futures.forEach((f)-> {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println("end time: " + (System.currentTimeMillis()) + "ms");
        System.out.println("used time: " + (System.currentTimeMillis()- startTime) + "ms");
        es.shutdown();
    }


    public static void usePrepareStatement() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        System.out.println("use prepare statement insert 1m data。 start time: " + DateFormat.getDateInstance().format(startTime) );

        CRUDWithPrepareStatement crudWithPrepareStatement = new CRUDWithPrepareStatement();
        crudWithPrepareStatement.createConnection();
        PreparedStatement preparedStatement = (PreparedStatement) crudWithPrepareStatement.createPreparedStatement("insert into shop.order values (?, 1, 1, 1000, '0', 10, now(),now());");

        try
        {
            for(int i = 0; i <= 1000000; i++)
            {
                preparedStatement.setInt(1, i);
                crudWithPrepareStatement.executeUpdate();
            }
        }
        catch (SQLException e)
        {
           crudWithPrepareStatement.rollback();
            throw e;
        }
        crudWithPrepareStatement.commit();

        System.out.println("used time: " + (System.currentTimeMillis()- startTime) + "ms");
        crudWithPrepareStatement.close();

    }

    public static void useJDBC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        long startTime = System.currentTimeMillis();
        System.out.println("use JDBC insert 1m data。 start time: " + DateFormat.getDateInstance().format(startTime) );

        CRUDWithJDBC crudWithJDBC = new CRUDWithJDBC();
        crudWithJDBC.createConnection();
        crudWithJDBC.createStatement();
        try
        {
            for(int i = 0; i <= 1000000; i++)
            {
                String insertSql = String.format("insert into shop.order values (%d, 1, 1, 1000, '0', 10, now(),now());", i);
                crudWithJDBC.executeUpdate(insertSql);
            }
        }
        catch (SQLException e)
        {
            crudWithJDBC.rollback();
            throw e;
        }
        crudWithJDBC.commit();

        System.out.println("used time: " + (System.currentTimeMillis()- startTime) + "ms");
        crudWithJDBC.close();
    }

//    public static void useBatch() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        long startTime = System.currentTimeMillis();
//        System.out.println("use prepare statement insert 1m data。 start time: " + DateFormat.getDateInstance().format(startTime) );
//
//        CRUDWithPrepareStatement crudWithPrepareStatement = new CRUDWithPrepareStatement();
//        crudWithPrepareStatement.createConnection();
//        PreparedStatement preparedStatement = (PreparedStatement) crudWithPrepareStatement.createPreparedStatement("insert into shop.order values (?, 1, 1, 1000, '0', 10, now(),now());");
//
//        try
//        {
//            for(int i = 0; i <= 1000000; i++)
//            {
//                preparedStatement.setInt(1, i);
//                crudWithPrepareStatement.executeUpdate();
//            }
//        }
//        catch (SQLException e)
//        {
//            crudWithPrepareStatement.rollback();
//            throw e;
//        }
//        crudWithPrepareStatement.commit();
//
//        System.out.println("used time: " + (System.currentTimeMillis()- startTime) + "ms");
//        crudWithPrepareStatement.close();
//
//    }

}
