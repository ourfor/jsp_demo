package download;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={
        "/LoginDownloadFile",
        "/NeedLogin"
})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws IOException,ServletException{

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if(userName!=null&&userName.equals("Sagit")&&password!=null&&password.equals("2320813747")){
            HttpSession session = request.getSession(true);
            session.setAttribute("LoggedIn",Boolean.TRUE);
            response.sendRedirect("download");
            return;
        }

        else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }
    }
}
