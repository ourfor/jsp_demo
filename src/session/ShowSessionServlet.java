package session;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(
        name="SessionManager",
        urlPatterns={
                "/Session",
                "/getSession"
        }
)
public class ShowSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws IOException,ServletException{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(true);
        Integer accessCount = (Integer) session.getAttribute("accessCount");
        String heading = null;

        if(accessCount==null){
            heading = "还未登录,请先登录";
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request,response);
        }
        else {
            heading= "欢迎再次登录";
            accessCount +=1;

        }

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><html><head><title>"+"欢迎再次登录");
        out.println("</title><link rel='shortcut icon' href='https://book.ourfor.top/favicon.ico'></head>");
        out.println("<body>");
        out.println("返回登录前页面");
        out.println("</body>");
        out.println("</html>");

        request.setAttribute("accessCount",accessCount);




    }

    protected void doPost(HttpServletRequest request,
                     HttpServletResponse response)
        throws IOException,ServletException{

        doGet(request,response);

    }
}
