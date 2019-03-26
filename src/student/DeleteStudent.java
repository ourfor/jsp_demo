package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class DeleteStudent extends StudentServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        List<Student> students = (List<Student>)request.getAttribute("students");
//        java.io.PrintWriter out = response.getWriter();
//        out.println("成功接收信息");
        int id = Integer.parseInt(request.getParameter("id"));
        int i;
        for(i=0;i<students.size();i++){
            if(students.get(i).getId()==id) break;
        }
        String command = "delete from info where SID="+id+";";
        user.ConnectDBSingleton.getIns().ModifyDB(command);
        students.remove(i);
        request.setAttribute("students",students);
        RequestDispatcher rd = request.getRequestDispatcher("/ShowStudent");
        rd.forward(request,response);

    }
}
