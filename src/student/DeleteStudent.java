package student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteStudent extends StudentServlet {
    @Override
    protected void printContent(HttpServletResponse response, HttpServletRequest request, List<Student> students) throws IOException, ServletException {

    }
}
