package dbsource;
import java.io.IOException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;


@WebServlet(
        name="DataSource",
        urlPatterns={
                "/DataSource"
        }
)
public class connect extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource ds;
    public void init(){
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/shopInfo");
        }
        catch(NamingException ne){
            System.out.println(ne.toString());
        }
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws IOException,ServletException{

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html><head><title>连接池对象</title></head><body>");
        out.println("<p>商品信息</p>");
        try {
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.HOLD_CURSORS_OVER_COMMIT);
            String sql = "select name,id,price from product;";
            ResultSet rs = statement.executeQuery(sql);
            out.println("<table>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("语句执行完毕");
        }
        catch(Exception e){
            System.out.println("捕获到异常:"+e.toString());
        }

        out.println("</body></html>");


    }
}

