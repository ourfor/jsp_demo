package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

public class AddStudent extends StudentServlet{
    public String message = "AddStudent";
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML><html><head><title>"
                +Title+"</title></head><body><p>"+Title+"</p>"
        );
        out.println("<form method='post' action='InsertStudent'");
        out.println("<table><tr><td>学号</td><td><input type='text' name='id'></td></tr>");
        out.println("<tr><td>姓名</td><td><input type='text' name='name'>" +
                "</td></tr>");
        out.println("<tr><td>年龄</td><td><input type='text' name='age'>" +
                "</td></tr>");
        out.println("<tr><td>QQ号</td><td><input type='text' name='qq'>" +
                "</td></tr>");
        out.println("<tr><td><input type='submit' value='确认'></td></tr>");
        out.println("</table>");
        out.println("</body></html>");

    }

}
