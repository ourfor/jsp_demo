package account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


@WebServlet(
        name="login",
        urlPatterns={
                "/Login",
                "/SignIn"
        }
)
public class Login extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{

                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Integer accessCount = (Integer) request.getAttribute("accessCount");

                if(username.equals("Sagit")&&password.equals("23208")) {
                        accessCount=1;
                        HttpSession session = request.getSession(true);
                        session.setAttribute("accessCount",accessCount);
                }

                RequestDispatcher rd = request.getRequestDispatcher("./Session");
                rd.forward(request,response);

        }

        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws IOException,ServletException{
                doGet(request,response);

        }
}
