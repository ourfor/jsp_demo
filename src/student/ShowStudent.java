package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import user.ConnectDBSingleton;

public class ShowStudent extends StudentServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        List<Student> students = ConnectDBSingleton.getIns().getStudents();

        out.println("<!DOCTYPE HTML><html><head><title>"
                +Title+"</title></head><body><p>"+Title+"</p>"
        );
        out.println("<table>");
        out.println("<tr><th>姓名</th><th>年龄</th><th>QQ</th></tr>");
        for(Student student:students){
            out.println("<tr><td>"+student.getName()+"</td>" +
                    "<td>"+student.getAge()+"</td><td>"
                    + student.getQq()+"</td>"
                    + "<td><a href='EditStudent?id="+student.getId()+"'>修改</a></td>"
                    + "<td><a href='DeleteStudent?id="+student.getId()+"'>删除</a></td></tr>"
            );
        }
        out.println("</table>");
        out.println("</body></html>");
        request.setAttribute("students",students);
    }
}
