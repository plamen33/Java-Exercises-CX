package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/generate")
public class GenerateServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("generate.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String submit = request.getParameter("submitNameAndAge");
        if(submit!=null){
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("age", age);
            response.sendRedirect("/print");
        }
    }
}