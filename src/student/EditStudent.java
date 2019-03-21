package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

public class EditStudent extends StudentServlet {
    public String message = "EditStudent";
    @Override
    protected void DealReq(HttpServletRequest request) throws IOException, ServletException {

    }

    @Override
    protected void printContent(HttpServletResponse response,
                                HttpServletRequest request,
                                List<Student> students) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        int index = 0;
        for(Student student:students){
            if(student.getId().equals(id)) break;
            index++;
        }
        index=(students.get(index).getId().equals(id))?index:index+1;
        Student student = students.get(index);
        if(student!=null) {
            out.println("<form method='get' action='UpdateStudent'>");
            out.println("<input type='hidden' name='id' value='" + id + "'");
            out.println("<table>");
            out.println("<tr><td>姓名</td><td><input type='text' name='name' value='"
                    + student.getName() + "'></td>");
            out.println("<tr><td>年龄</td><td><input type='text' name='age' value='"
                    + student.getAge() + "'></td>");
            out.println("<tr><td>QQ号</td><td><input type='text' name='qq' value='"
                    + student.getQq() + "'></td>");
            out.println("<tr><td><input type='submit' value='确认'></td>" +
                    "<td><input type='reset' value='重置'></td>");
            out.println("</table>");
        }
        else{
            out.println("没有找到学生");
        }


    }
}
