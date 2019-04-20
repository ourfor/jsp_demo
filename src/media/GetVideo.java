package media;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


@WebServlet(
        name="getVideo",
        urlPatterns={
                "/GetVideo"
        }
)

public class GetVideo extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)
                throws IOException,ServletException{
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/video");

                ServletContext context = getServletConfig().getServletContext();
                String VideoPath = context.getRealPath("WEB-INF/data/video");
                File video = new File(VideoPath,"intro.mkv");

                try{
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    BufferedOutputStream bos = null;
                    fis = new FileInputStream(video);
                    bis = new BufferedInputStream(fis);

                }
                catch(Exception e){
                        System.out.println(e.toString());
                }

        }
}
