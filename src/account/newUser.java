package account;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import com.mysql.jdbc.*;

public class newUser {
    private void addToDB(String username,String password,String email){
        String uri = "jdbc:mysql://db.ourfor.top/Demo?useSSL=true&characterEncoding=UTF-8";
        String user = "root";
        String passwd = "2320813747DBmm$$";
        try {
            Connection conn = DriverManager.getConnection(uri, user, passwd);
            String sql = "insert into user (username,password,email) value (" +
                    "'" +username+"'"+",'"+password+"'"+",'"+email+"'"+
                    ");";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
