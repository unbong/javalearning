package Week5_Spring.springdemo.homeworks.homework10.JDBC;

import java.sql.*;


/**
 * 使用 JDBC 原生接口，实现数据库的增删改查操作。
 *
 */
public class CRUDWithJDBC {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet rs =null;

    public Statement getStatement()
    {
        return statement;
    }

    public void createConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        connection = DriverManager.getConnection( "jdbc:mysql://192.168.56.10:3306/gulimall_pms?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
        connection.setAutoCommit(false);
    }

    public Statement createPreparedStatement(String sql) throws SQLException {

        return connection.prepareStatement(sql);
    }

    public void createStatement() throws SQLException {
        statement = connection.createStatement();
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public ResultSet executeSQL (String sql ) throws SQLException {
        if (statement instanceof PreparedStatement) {
            PreparedStatement preparedStatement = (PreparedStatement) statement;
            return preparedStatement.executeQuery();
        }
        else
        {
           return statement.executeQuery(sql);
        }
//
    }

    public int executeUpdate(String sql) throws SQLException
    {

        if (statement instanceof PreparedStatement) {
            PreparedStatement preparedStatement = (PreparedStatement) statement;
            return  preparedStatement.executeUpdate();
        }
        else
        {
            return statement.executeUpdate(sql);
        }

    }

    public  void close() throws SQLException {

        if(rs != null) rs.close();
        if(statement != null) statement.close();
        if(connection != null) connection.close();

    }




}
