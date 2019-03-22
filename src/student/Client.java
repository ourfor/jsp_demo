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
                "/DeleteStudent"
        }
)

public class Client extends HttpServlet{
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

            List<Student> students = new ArrayList<Student>();
            Student stu1 = new Student("101", "王小明", 23, "8899123");
            Student stu2 = new Student("102", "张大海", 20, "11223355");
            students.add(stu1);
            students.add(stu2);

            request.setAttribute("students",students);

            //确定组织关系
            a.setNext(b);
            b.setNext(c);
            c.setNext(d);

            //设置标题
            a.setTitle("显示学生信息");
            b.setTitle("添加学生信息");
            c.setTitle("修改编辑学生信息");

            a.setMessage("ShowStudent");
            b.setMessage("EditStudent");
            c.setMessage("AddStudent");
            d.setMessage("InsertStudent");

        String message = request.getRequestURI();
        request.setAttribute("message",message);


        a.Judge(request,response);

    }
}
