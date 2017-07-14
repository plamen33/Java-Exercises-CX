package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/print")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = session.getAttribute("name").toString();
        String age = session.getAttribute("age").toString();
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.getRequestDispatcher("/print.jsp").forward(request, response);
    }
}
