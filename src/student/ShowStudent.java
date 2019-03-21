package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowStudent extends StudentServlet {
    @Override
    protected void printContent(HttpServletResponse response,
                                HttpServletRequest request,
                                List<Student> students) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("<table>");
        for(Student student:students){
            out.println("<tr><td>"+student.getName()+"</td>" +
                    "<td>"+student.getAge()+"</td><td>"
                    + student.getQq()+"</td>"
                    + "<td><a href='EditStudent?id="+student.getId()+"'>修改</a></td>"
                    + "<td><a href='DeleteStudent?id="+student.getId()+"'>删除</a></td></tr>"
            );
        }
        out.println("</table>");
    }
}
