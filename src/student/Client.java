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
                "/UpdateStudent"
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
            StudentServlet n = new NullObject();

            List<Student> students = new ArrayList<Student>();
            Student stu1 = new Student("101", "王小明", 23, "8899123");
            Student stu2 = new Student("102", "张大海", 20, "11223355");
            students.add(stu1);
            students.add(stu2);

            //确定组织关系
            a.setNext(b);
            b.setNext(c);
            c.setNext(n);

            //设置标题
            a.setTitle("显示学生信息");
            b.setTitle("添加学生信息");
            c.setTitle("修改编辑学生信息");

            a.setMessage("ShowStudent");
            b.setMessage("EditStudent");
            c.setMessage("AddStudent");

        String message = request.getRequestURI();
//        if(message.endsWith("ShowStudent")) {
//
//            java.io.PrintWriter out = response.getWriter();
//            out.println("" + message);
//        }

        a.Judge(message,request,response,students);

    }
}
