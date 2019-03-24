package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class DeleteStudent extends StudentServlet {
    @Override
    protected void printContent(HttpServletResponse response, HttpServletRequest request, List<Student> students) throws IOException, ServletException {
//        java.io.PrintWriter out = response.getWriter();
//        out.println("成功接收信息");
        String id = request.getParameter("id");
        int i;
        for(i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)) break;
        }
        students.remove(i);
        request.setAttribute("students",students);
        RequestDispatcher rd = request.getRequestDispatcher("/ShowStudent");
        rd.forward(request,response);

    }
}
