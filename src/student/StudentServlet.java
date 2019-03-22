package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class StudentServlet extends HttpServlet{
    protected String Title = "";
    protected String message;

    public void setTitle(String title) {
        Title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNext(StudentServlet next) {
        this.next = next;
    }

    protected StudentServlet next;

    protected void Judge(String message,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         List<Student> students)
            throws IOException,ServletException{

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        if(message.endsWith(this.message)) doGet(request,response,students);
        else next.Judge(message,request,response,students);

    }


    public void doGet(HttpServletRequest request,
                         HttpServletResponse response,
                         List<Student> students)
            throws IOException,ServletException{

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML><html><head><title>"
                +Title+"</title></head><body><p>"+Title+"</p>"
        );
        printContent(response,request,students);
        out.println("</body></html>");
    }


    protected abstract void printContent(HttpServletResponse response,
                                         HttpServletRequest request,
                                         List<Student> students)
            throws IOException,ServletException;

}
