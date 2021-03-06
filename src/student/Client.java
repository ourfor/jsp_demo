package student;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        name="mainServlet",
        urlPatterns={
                "/ShowStudent",
                "/EditStudent",
                "/AddStudent",
                "/UpdateStudent",
                "/InsertStudent",
                "/DeleteStudent",
                "/ModifyStudent"
        }
)

public class Client extends HttpServlet{
    private int count = 0;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException,ServletException{

            //统一编码
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            StudentServlet a = new ShowStudent();
            StudentServlet b = new EditStudent();
            StudentServlet c = new AddStudent();
            StudentServlet d = new InsertStudent();
            StudentServlet f = new DeleteStudent();
            StudentServlet g = new ModifyStudent();

            //request.getAttribute("students")==null
            if((request.getAttribute("students")==null)&&(count==0)) {
                    List<Student> students = user.ConnectDBSingleton.getIns().getStudents();
                    request.setAttribute("students", students);
            }


            //确定组织关系
            a.setNext(b);
            b.setNext(c);
            c.setNext(d);
            d.setNext(f);
            f.setNext(g);

            //设置标题
            a.setTitle("显示学生信息");
            b.setTitle("修改学生信息");
            c.setTitle("修改编辑学生信息");


            a.setMessage("ShowStudent");
            b.setMessage("EditStudent");
            c.setMessage("AddStudent");
            d.setMessage("InsertStudent");
            f.setMessage("DeleteStudent");
            g.setMessage("ModifyStudent");

        String message = request.getRequestURI();
        request.setAttribute("message",message);


        a.Judge(request,response);

    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException,ServletException{
        doGet(request,response);

    }
}
