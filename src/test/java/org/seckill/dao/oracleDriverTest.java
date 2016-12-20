package org.seckill.dao;
import java.sql.*;

/**
 * Created by shou on 2016/12/20.
 */
public class oracleDriverTest {
    public static void main(String[] args) {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:myOracle";
        String user="sc_user";
        String pass="sc_password";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con= DriverManager.getConnection(url, user, pass);
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from SECKILL");
            while(resultSet.next()){
                int id=resultSet.getInt("seckill_id");
                System.out.println(id);
            }
            if (con!=null){
                con.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
