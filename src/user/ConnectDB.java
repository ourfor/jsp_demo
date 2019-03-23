package user;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn;
            String uri= "jdbc:mysql://db.ourfor.top:3306/DynamicWeather?useSSL=true&characterEncoding=UTF-8";
            String user="root";
            String password="2320813747DBmm$$";
            try{
                conn = DriverManager.getConnection(uri,user,password);
                System.out.println("连接成功");

                Statement sql;
                try{
                    sql = conn.createStatement();
                    ResultSet rs = sql.executeQuery("select * from Year2019;");

                    System.out.printf("%s\t","日期");
                    System.out.printf("%s\t","节气");
                    System.out.printf("%s\t\n","描述");

                    while(rs.next()){
                        String date = rs.getString(1);
                        String SolarTerm = rs.getString(2);
                        String Description = rs.getString(3);

                        System.out.printf("%s\t",date);
                        System.out.printf("%s\t",SolarTerm);
                        System.out.printf("%s\t\n",Description);

                    }

                    conn.close();

                }
                catch(SQLException e){

                }
            }
            catch(Exception e){
                System.out.println("连接失败");

            }



        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("驱动加载异常");
        }
    }
}
