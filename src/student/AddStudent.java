package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

public class AddStudent extends StudentServlet{
    @Override
    protected void printContent(HttpServletResponse response, HttpServletRequest request, List<Student> students) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("<form method='post' action='InsertStudent'");

    }
}
