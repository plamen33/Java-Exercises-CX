package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;

@WebServlet("/datetime")
public class DateHourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("This servlet prints current date and time in a simple way: ").append(request.getContextPath());
        response.getWriter().println();
        response.getWriter().println();
        response.getWriter().append("Today's date is: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        response.getWriter().println();
        response.getWriter().println();
        response.getWriter().append("Current time is: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
