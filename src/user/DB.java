package user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DB {
    private static String uri = "jdbc:mysql://db.ourfor.top:3306/Student?useSSL=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "2320813747DBmm$$";
    public static void main(String args[]){
        try{
            Connection conn = DriverManager.getConnection(uri,user,password);
            Statement sql = conn.createStatement();
            String command = "delete from info where SID=20180105";
            sql.executeUpdate(command);
            command = "select * from info;";
            ResultSet rs = sql.executeQuery(command);
            while(rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
