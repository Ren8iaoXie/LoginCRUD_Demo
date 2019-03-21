import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author xieren8iao
 * @create 2019/3/19 - 15:25
 */
@WebServlet("/aServlet")
public class AServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("你好");


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            this.doPost(request,response);

    }
}
