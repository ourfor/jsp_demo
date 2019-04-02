package file;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name="saveFile",
        urlPatterns={
                "/SaveFile",
                "/Upload.do",
                "/upload.do"
        }
)
@MultipartConfig(
        location = ".",
        fileSizeThreshold = 1024
)
public class SaveUploadFile extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                throws IOException,ServletException{

                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                Part HeadInfo = request.getPart("filename");
                String ContentDisposition = HeadInfo.getHeader("Content-Disposition");
                String savePath = this.getServletContext().getRealPath("/");
                String fileName = ContentDisposition.substring(
                        ContentDisposition.lastIndexOf("filename") + 10,
                        ContentDisposition.length() - 1
                );

                //判断文件大小 大于1MB

                String message = "";

                if(HeadInfo.getSize()>1024*1024){
                        message = "文件大小大于1MB,请重新上传";
                        HeadInfo.delete();
                }
                else{
                        savePath+="/upload";
                        File dirUpload = new File(savePath);
                        if(!dirUpload.exists()){
                                dirUpload.mkdir();
                        }
                        message = "文件上传成功";
                        HeadInfo.write(savePath+"/"+fileName);
                        request.setAttribute("filename",fileName);
                }

                request.setAttribute("message",message);

                RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
                rd.forward(request,response);

        }
}
