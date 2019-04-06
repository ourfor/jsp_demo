package account;
import user.ConnectDBSingleton;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.List;


@WebServlet(
        name="login",
        urlPatterns={
                "/Login",
                "/SignIn"
        }
)
public class login extends HttpServlet {
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

                ConnectDBSingleton db = ConnectDBSingleton.getIns();

                String dbPassword="";
                        String Statement = "select username,password from user where username='" +
                                username +
                                "';";
                        System.out.println(Statement);
                        db.setDatabase("Demo");
                        List<String> result = db.getResult(Statement,2);
                        try {
                                dbPassword = result.get(0);
                        }
                        catch(Exception e){
                                System.out.println(e);
                        }

                if(result!=null&&password.equals(dbPassword)) {
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
