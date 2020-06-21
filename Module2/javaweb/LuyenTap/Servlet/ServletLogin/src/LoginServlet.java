import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = new PrintWriter(response.getWriter());
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Date date = new Date();
        if (account.equals("hieu") && password.equals("123456")) {
            pw.println("<html>");
            pw.println("Hello " + account + ". Bay gio la: " + date.getHours()+":"+date.getMinutes());
            pw.println("</html>");
        } else {
            pw.println("<html>");
            pw.println("<h1>Login Error</h1>");
            pw.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
