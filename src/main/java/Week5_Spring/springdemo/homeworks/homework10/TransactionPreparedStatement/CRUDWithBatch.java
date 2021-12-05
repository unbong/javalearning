package Week5_Spring.springdemo.homeworks.homework10.TransactionPreparedStatement;

import Week5_Spring.springdemo.homeworks.homework10.JDBC.CRUDWithJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 批处理方式
 *
 */
public class CRUDWithBatch {

    private CRUDWithJDBC jdbcController;
    private Statement statement  = null;
    public CRUDWithBatch()
    {
        jdbcController = new CRUDWithJDBC();
    }

    public void createConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jdbcController.createConnection();


    }

    public void createStatment () throws SQLException {
         jdbcController.createStatement();
        statement = jdbcController.getStatement();
    }

    public void addBatch(String sql) throws SQLException {
        statement.addBatch(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
       return jdbcController.executeSQL(sql);
    }


    public int[] executeBatch() throws SQLException {
        int [] result = null ;
        try {
            result = statement.executeBatch();
            jdbcController.commit();
            return result;
        }catch (SQLException e)
        {
            jdbcController.rollback();
            throw e;
        }

    }


}
