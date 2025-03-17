
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PatientHome")
public class PatientHome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String uname = (String) session.getAttribute("uname");
            request.setAttribute("uname", uname);
            request.getRequestDispatcher("PatientHome.html").forward(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }
}
