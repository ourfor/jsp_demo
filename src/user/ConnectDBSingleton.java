package user;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;

public class ConnectDBSingleton {
    private static ConnectDBSingleton Ins;
    private ConnectDBSingleton(){}

    public static ConnectDBSingleton getIns(){
        if(Ins==null) Ins = new ConnectDBSingleton();
        return Ins;
    }

    public void Connect(){
        Connection conn;
        try{
            String uri = "jdbc:mysql://db.ourfor.top:3306/DynamicWeather?useSSL=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "2320813747DBmm$$";
            conn = DriverManager.getConnection(uri,user,password);

            Statement sql = conn.createStatement();

            String command = "select * from Year2019 order by Date;";

            ResultSet rs = sql.executeQuery(command);

            while(rs.next()){
                String date = rs.getString(1);
                String solarterm = rs.getString(2);
                String description = rs.getString(3);
                System.out.printf("%s\t",date);
                System.out.printf("%s\t",solarterm);
                System.out.printf("%s\t\n",description);
            }
        }
        catch(Exception e){
           System.out.println("数据库连接失败");
        }
    }
}
