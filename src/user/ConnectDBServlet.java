package user;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name="DBConnect",
        urlPatterns={
                "/dbConnect"
        }
)

public class ConnectDBServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private ResultSet rs;
        protected void ConnectDB(){
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        String uri = "jdbc:mysql://db.ourfor.top:3306/DynamicWeather?useSSL=true&characterEncoding=UTF-8";
                        String username = "root";
                        String password = "2320813747DBmm$$";

                        Connection conn = DriverManager.getConnection(uri,username,password);

                        Statement sql = conn.createStatement();

                        this.rs = sql.executeQuery("select * from Year2019;");

                }
                catch(Exception e){
                       System.out.println("连接失败");
                }
        }

        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{

                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();

                out.println("<!DOCTYPE HTML><html><head><title>24节气</title><link rel='shrotcut icon' href" +
                        "='https://book.ourfor.top/favicon.ico'> " +
                        "<style>body{text-align:center}table{margin: auto}table,td,tr,th{border:1px solid blueviolet}table{border-spacing:0}th{font-size:1.5em;color:red}</style>" +
                        "</head><body>");
                ConnectDB();
                try{
                        out.println("<table>");
                        out.println("<tr><th>日期</th><th>节气</th><th>描述</th></tr>");
                        while(rs.next()){
                                String date = rs.getString(1);
                                String SolarTerms = rs.getString(2);
                                String Description = rs.getString(3);
                                out.print("<tr><td>"+date+"</td>" +
                                        "<td>"+SolarTerms+"</td>" +
                                        "<td>"+Description+"</td></tr>");
                        }
                        out.println("</table>");
                }
                catch(Exception e){
                        System.out.println("查询的表不存在或者为空");
                }
                out.println("</body><html>");




        }
}
