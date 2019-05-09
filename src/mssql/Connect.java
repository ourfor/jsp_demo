package mssql;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Connect {
    public static void main(String args[]){
        String name = "Sagit";
        String password = "2320813747$$";
        String uri = "jdbc:sqlserver://db.ourfor.top:1433;databaseName=Study";

        try{
            Connection conn = DriverManager.getConnection(uri,name,password);
            Statement statement = conn.createStatement();
            String sql = "select * from student;";
            ResultSet rs = statement.executeQuery(sql);


            while(rs.next()){
                System.out.print(rs.getString(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                System.out.println();
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
