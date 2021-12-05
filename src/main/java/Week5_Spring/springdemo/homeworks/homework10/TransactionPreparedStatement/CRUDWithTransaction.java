package Week5_Spring.springdemo.homeworks.homework10.TransactionPreparedStatement;


import Week5_Spring.springdemo.homeworks.homework10.JDBC.CRUDWithJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  使用事务
 *
 *
 */
public class CRUDWithTransaction {

    private CRUDWithJDBC jdbcController = null ;

    public CRUDWithTransaction()
    {
        jdbcController = new CRUDWithJDBC();

    }

    public void createConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jdbcController.createConnection();

    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return   jdbcController.executeSQL(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        int result = -1;
        try {
            result = jdbcController.executeUpdate(sql)  ;
            jdbcController.commit();
            return result;
        }
        catch (SQLException e)
        {
            jdbcController.rollback();
            throw e;
        }

    }

    public void close() throws SQLException {
        jdbcController.close();
    }

}
