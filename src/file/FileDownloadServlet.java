package file;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name="fileDownload",
        urlPatterns={
                "/fileDownload",
                "/LoginDownload"
        }
)
public class FileDownloadServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{
                request.setCharacterEncoding("UTF-8");
//                response.setContentType("text/html;charset=UTF-8");
                response.setContentType("image/gif");
                response.setHeader("Content-Disposition","attachment;filename=duke.gif");
                response.setCharacterEncoding("UTF-8");

                OutputStream os = response.getOutputStream();
                ServletContext context = getServletContext();

                InputStream is = context.getResourceAsStream("https://file.ourfor.top/album/ps.png");

                byte[] bytearray = new byte[1024];
                int bytesread = 0;
                while((bytesread=is.read(bytearray))!=-1){
                        os.write(bytearray,0,bytesread);
                }
                os.flush();
                is.close();



        }
}
