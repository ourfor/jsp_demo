package write;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name="write",
        urlPatterns={
                "/Write",
                "/SavePage"
        }
)
public class SaveWrite extends HttpServlet {
        private static final long serialVersion = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{

                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");

                String md = request.getParameter("markdown");
                String html = request.getParameter("html");

                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE HTML><html>" +
                        "<head>" +
                        "<script src='./libs/jquery.min.js'></script>" +
                        "<link rel='stylesheet' type='text/css' href='./libs/css/editormd.preview.min.css'>" +
                        "</head>" +
                        "<body>");
                out.println(html);
                out.println("</body></html>");

        }

        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws IOException,ServletException{
               doGet(request,response);
        }
}
