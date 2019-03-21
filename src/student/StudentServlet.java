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
    protected StudentServlet next;

    protected void Judge(String message,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         List<Student> students)
            throws IOException,ServletException{
        if(this.message.equals(message)) doGet(request,response,students);
        else next.Judge(message,request,response,students);

    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response,
                         List<Student> students)
            throws IOException,ServletException{
        printHeader(response);
        printContent(response,request,students);
        printFooter(response);
    }

    protected void printHeader(HttpServletResponse response)
            throws IOException,ServletException{
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><html><head><title>"
                +Title+"</title></head><body><p>"+Title+"</p><table>"
        );
    }

    protected void printFooter(HttpServletResponse response)
            throws IOException,ServletException{
        PrintWriter out = response.getWriter();
        out.println("</table></body></html>");

    }

    protected abstract void printContent(HttpServletResponse response,
                                         HttpServletRequest request,
                                         List<Student> students)
            throws IOException,ServletException;
}
