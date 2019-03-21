package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

public class EditStudent extends StudentServlet {
    @Override
    protected void printContent(HttpServletResponse response,
                                HttpServletRequest request,
                                List<Student> students) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        out.println("<form method='get' action='UpdateStudent'>");
        out.println("<input type='hidden' name='id' value='"+id+"'");
    }
}
