package download;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


@WebServlet(
        name="Download",
        urlPatterns={
                "/download"
        }
)
public class DownloadFile extends HttpServlet {
        private static final long serialVersionUID  = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");

                HttpSession session = request.getSession();
                if(session==null||session.getAttribute("loggedIn")==null) {
                        RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
                        rq.forward(request,response);
                        return;
                }

                String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
                File file = new File(dataDirectory,"servlet-spec.pdf");

                if(file.exists()){
                        response.setContentType("application/pdf");
                        response.addHeader("Content-Dispositon","attachment;filename=servlet-spec.pdf");
                        byte[] buffer = new byte[1024];
                        FileInputStream fis = null;
                        BufferedInputStream bis = null;
                        try{
                            fis = new FileInputStream(file);
                            bis = new BufferedInputStream(fis);
                            OutputStream os = response.getOutputStream();
                            int i = bis.read(buffer);
                            while(i!=-1){
                                    os.write(buffer,0,1);
                                    i = bis.read(buffer);
                            }

                        }
                        catch(IOException ex){
                            System.out.println(ex.toString());
                        }
                        finally{
                            if(bis!=null){
                                bis.close();
                            }
                            if(fis!=null){
                                fis.close();
                            }
                        }
                }
                else{
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("你要的文件不存在");
                }

        }
}
