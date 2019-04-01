package file;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class FileDownloadServletB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws IOException,ServletException{

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        if(session==null||request.getAttribute("session")==null){
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request,response);
            return;  //该语句是必须的
        }
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
        File file = new File(dataDirectory,"servlet-spec.pdf");
        if(file.exists()){
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","attachment;filename=servlet-spec.pdf");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i!=1){
                    os.write(buffer,0,1);
                    i = bis.read(buffer);
                }
            }
            catch(IOException ex){
                System.out.println(""+ex.toString());
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


    }

}
