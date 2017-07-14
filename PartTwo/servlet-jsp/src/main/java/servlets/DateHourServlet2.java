package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class DateHourServlet2  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> dateTimeList = new ArrayList<String>(){{
            add("Today's date is: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            add("Current time is: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }};
        request.setAttribute("dateTimeList", dateTimeList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String generate = request.getParameter("generate");
        if(generate!=null){
            response.sendRedirect("/generate");
        }
        String datetime = request.getParameter("datetime");
        if(datetime != null){
            response.sendRedirect("/datetime");
        }
        String home = request.getParameter("home");
        if(home != null){
            response.sendRedirect("/home.html");
        }
    }
}
