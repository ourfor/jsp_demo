package user;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import student.Student;
import com.mysql.jdbc.Driver;

public class ConnectDBSingleton {
    //private List<Student> students;
    private static ConnectDBSingleton Ins;
    private ConnectDBSingleton(){}
    private Connection conn;
    private String uri = "jdbc:mysql://db.ourfor.top:3306/Student?useSSL=true&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "2320813747DBmm$$";

    public static ConnectDBSingleton getIns(){
        if(Ins==null) Ins = new ConnectDBSingleton();
        return Ins;
    }

    public ResultSet Connect(){
        try{

            conn = DriverManager.getConnection(uri,user,password);

            Statement sql = conn.createStatement();

            String command = "select * from info order by SID;";

            ResultSet rs = sql.executeQuery(command);
            return rs;

//            while(rs.next()){
//                String Name = rs.getString(1);
//                int SID = Integer.parseInt(rs.getString(2));
//                int Age = Integer.parseInt(rs.getString(3));
//                System.out.printf("%s\t",Name);
//                System.out.printf("%d\t",SID);
//                System.out.printf("%d\t\n",Age);
//            }
        }
        catch(Exception e){
           System.out.println("数据库连接失败");
        }
        return null;
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        ResultSet rs = this.Connect();
        try {
            while (rs.next()) {
                String Name = rs.getString(1);
                int SID = Integer.parseInt(rs.getString(2));
                int Age = Integer.parseInt(rs.getString(3));
                int QQ = Integer.parseInt(rs.getString(4));
                students.add(new Student(SID,Name,Age,QQ));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return students;

    }

    public List<Student> ModifyDB(String statement){
        try {
            conn.close();
            conn = DriverManager.getConnection(uri,user,password);
            Statement sql = conn.createStatement();
            sql.executeUpdate(statement);
            sql.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return getStudents();
    }
}
