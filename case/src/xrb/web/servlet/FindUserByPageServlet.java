package xrb.web.servlet;

import xrb.entry.PageBean;
import xrb.entry.User;
import xrb.service.UserService;
import xrb.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**分页功能servlet
 * @author xieren8iao
 * @create 2019/3/21 - 9:13
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        request.setCharacterEncoding("utf-8");
        String rows = request.getParameter("rows");

        Map<String, String[]> condiction = request.getParameterMap();

        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }

        UserService service=new UserServiceImpl();
        PageBean<User> pageBean=service.findUserByPage(currentPage,rows,condiction);
        System.out.println(pageBean);
        request.setAttribute("pb", pageBean);
        request.setAttribute("condiction", condiction);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
