package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class InsertStudent extends StudentServlet{
    @Override
    protected void printContent(HttpServletResponse response, HttpServletRequest request, List<Student> students) throws IOException, ServletException {
//        String name=request.getParameter("name");
//        String id=request.getParameter("id");
//        int age=Integer.parseInt(request.getParameter("age"));
//        String qq=request.getParameter("qq");
//
//        students.add(new Student(id,name,age,qq));
        students.add(new Student("110","李白",23,"2320813747"));
        request.setAttribute("students",students);
//        java.io.PrintWriter out = response.getWriter();
//        for(Student student:students){
//            out.println(""+student.getName()+"<br>");
//        }
        RequestDispatcher rd = request.getRequestDispatcher("/ShowStudent");
        rd.forward(request,response);

    }
}
