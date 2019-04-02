package account;
import java.io.IOException;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name="signUp",
        urlPatterns={
                "/register.do",
                "/signUp.do"
        }
)
public class signUp extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws IOException,ServletException{

                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();

                String interest[];
                interest = request.getParameterValues("interest");

                //将标志代码转换成字符
                for(int i=0;i<interest.length;i++){
                        if(interest[i].equals("1")) interest[i]="文学";
                        else if(interest[i].equals("2")) interest[i]="体育";
                        else interest[i]="电脑";
                }

                for(String index:interest) interest[0]+=interest[0].equals(index)?"":" "+index;

                String sex = request.getParameter("sex").equals("1")?"男":"女";
                String education="";

                switch(request.getParameter("education")){
                        case "1":
                                education = "学士";
                                break;
                        case "2":
                                education = "博士";
                                break;
                        case "3":
                                education = "硕士";
                                break;

                }

                String layout = "css/layout/register.css";


                out.println("<!DOCTYPE HTML><html><head><title>用户信息</title></head>");
                out.println("<link type='text/css' rel='stylesheet' href='"+layout+"'>");
                out.println("<body>");
                out.println("<form>");
                out.println("<table style='text-align:left'>");
                out.println("<tr><td>用户名:</td><td>"+request.getParameter("username")+"</td></tr>");
                out.println("<tr><td>密码:</td><td>"+request.getParameter("password")+"</td></tr>");
                out.println("<tr><td>性别:</td><td>"+sex+"</td></tr>");
                out.println("<tr><td>年龄:</td><td>"+request.getParameter("age")+"</td></tr>");
                out.println("<tr><td>爱好:</td><td>"+interest[0]+"</td></tr>");
                out.println("<tr><td>学历:</td><td>"+education+"</td></tr>");
                out.println("<tr><td>邮件地址:</td><td>"+request.getParameter("email")+"</td></tr>");
                out.println("<tr><td>简历:</td><td>"+request.getParameter("resume")+"</td></tr>");
                out.println("<tr></tr>");
                out.println("<tr><td colspan='2'><input type='submit' value='我决定好了'><input type='button' value='我再想想'><td></tr>");
                out.println("</table>");
                out.println("</form>");

                out.println("</body></html>");

        }
}
