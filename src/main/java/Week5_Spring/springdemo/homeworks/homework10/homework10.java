package Week5_Spring.springdemo.homeworks.homework10;

import Week5_Spring.springdemo.homeworks.homework10.JDBC.CRUDWithJDBC;
import Week5_Spring.springdemo.homeworks.homework10.TransactionPreparedStatement.CRUDWithPrepareStatement;

import java.sql.*;



public class homework10 {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        //homework10.runCURDDemo();
        homework10.runPrepareStatementDemo();
    }

    public static void runPrepareStatementDemo() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        CRUDWithPrepareStatement controller = new CRUDWithPrepareStatement();
        String sql = "SELECT sku_id,  sku_name, sku_title, price FROM gulimall_pms.pms_sku_info where sku_id in (1,2,3);";
        controller.createConnection();
        PreparedStatement prepareStatement = (PreparedStatement) controller.createPreparedStatement(sql);
        ResultSet rs  = prepareStatement.executeQuery();

        while (rs.next())
        {
            String res = "ID：";
            res= res.concat(  rs.getString(1))
                    .concat("，name: ")
                    .concat(rs.getString(2))
                    .concat(", title：")
                    .concat(rs.getString(3))
                    .concat(", price：").concat(rs.getString(4))
                    .concat(".");

            System.out.println(res);
        }


    }


    public static void runCURDDemo()  throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CRUDWithJDBC controller = new CRUDWithJDBC();

        ResultSet rs = null;
        try {

            String sql = "SELECT sku_id,  sku_name, sku_title, price FROM gulimall_pms.pms_sku_info where sku_id in (1,2,3);";
            controller.createConnection();
            rs  = controller.executeSQL(sql);
            while (rs.next())
            {
                String res = "ID：";
                res= res.concat(  rs.getString(1))
                        .concat("，name: ")
                        .concat(rs.getString(2))
                        .concat(", title：")
                        .concat(rs.getString(3))
                        .concat(", price：").concat(rs.getString(4))
                        .concat(".");

                System.out.println(res);
            }

            String insertData = "INSERT INTO gulimall_pms.pms_sku_info (`spu_id`, `sku_name`, `catalog_id`, `brand_id`, `sku_default_img`, `sku_title`, `sku_subtitle`, `price`, `sale_count`) VALUES ('13', 'MEIZU', '225', '12', 'https://gulimall-hello.oss-cn-beijing.aliyuncs.com/2019-11-27/299481e9-4704-4824-8b18-60c7d268353c_7ae0120ec27dc3a7.jpg', 'MEIZU12', 'MEIZU 系列', '3338', '0')";
            int insertRes = controller.executeUpdate(insertData);

            System.out.println("Insert result " + insertRes);

            String query = "SELECT sku_id,  sku_name, sku_title, price FROM gulimall_pms.pms_sku_info where sku_name in ('MEIZU');";

            rs  = controller.executeSQL(query);
            while (rs.next())
            {
                String result = "ID：";
                result= result.concat(  rs.getString(1))
                        .concat("，name: ")
                        .concat(rs.getString(2))
                        .concat(", title：")
                        .concat(rs.getString(3))
                        .concat(", price：").concat(rs.getString(4))
                        .concat(".");

                System.out.println(result);
            }

        }
        finally {
            controller.close();
        }
    }

}
