package Week5_Spring.springdemo.homeworks.homework10.ConnectPool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 配置 Hikari 连接池
 *
 */
public class CRUDWithHikari {

    HikariDataSource ds = null;
    Connection connection = null;
    Statement  statement = null;

    public CRUDWithHikari()
    {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.56.10:3306/gulimall_pms?useUnicode=true&characterEncoding=UTF-8");
        config.setUsername("root");
        config.setPassword("root");

        ds= new HikariDataSource(config);

    }


    public void createConnection() throws SQLException {
        connection =  ds.getConnection();
        connection.setAutoCommit(false);
    }

    public void crearteStatement() throws SQLException {
        statement = connection.createStatement();

    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        int res = -1;

        try{
            res =statement.executeUpdate(sql);
            connection.commit();
            return res;
        }catch (SQLException e)
        {
            connection.rollback();
            throw e;

        }
    }


    public void close()
    {
        ds.close();
    }

}
