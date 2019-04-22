package obj;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet(
        name="ProductServlet",
        urlPatterns={
                "/ProductServlet"
        }
)
public class ProductServlet extends HttpServlet {
        private static final long serivalVersionUID = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

        }
}
