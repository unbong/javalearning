package Week5_Spring.springdemo.homeworks.homework10.TransactionPreparedStatement;

import Week5_Spring.springdemo.homeworks.homework10.JDBC.CRUDWithJDBC;
import org.checkerframework.checker.units.qual.C;

import java.sql.*;

/**
 *  PrepareStatement 方式
 *
 *
 */
public class CRUDWithPrepareStatement {


    private CRUDWithJDBC jdbcController;


    public CRUDWithPrepareStatement()
    {
        jdbcController = new CRUDWithJDBC();
    }

    public void createConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jdbcController.createConnection();
    }

    public Statement createPreparedStatement(String sql) throws SQLException {
        return jdbcController.createPreparedStatement(sql);
    }

    public ResultSet  executeQuery() throws SQLException {
        return jdbcController.executeSQL(null);
    }

    public int executeUpdate() throws SQLException {
        int result = -1;
        try
        {
            result =  jdbcController.executeUpdate(null);
            jdbcController.commit();
            return result;

        }
        catch (SQLException e)
        {
            jdbcController.rollback();
            throw e;
        }

    }

}
