package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModifyStudent extends StudentServlet {
    @Override
    protected void printContent(HttpServletResponse response, HttpServletRequest request, List<Student> students) throws IOException, ServletException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        int age = Integer.parseInt(request.getParameter("age"));
        String qq = request.getParameter("qq");

        int i;
        for(i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)) break;
        }

        Student update = students.get(i);
        update.setAge(age);
        update.setName(name);
        update.setQq(qq);

        students.set(i,update);
        request.setAttribute("students",students);

        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/ShowStudent");
        rd.forward(request,response);
    }
}
