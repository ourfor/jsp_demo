package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class InsertStudent extends StudentServlet{
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
//        String name=request.getParameter("name");
//        String id=request.getParameter("id");
//        int age=Integer.parseInt(request.getParameter("age"));
//        String qq=request.getParameter("qq");
//
//        students.add(new Student(id,name,age,qq));
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Student> students = (List<Student>) request.getAttribute("students");
        request.setAttribute("students",students);
//        java.io.PrintWriter out = response.getWriter();
//        for(Student student:students){
//            out.println(""+student.getName()+"<br>");
//        }
        RequestDispatcher rd = request.getRequestDispatcher("/ShowStudent");
        rd.forward(request,response);

    }
}
