package nl.hu.bep.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sayhello") //http://localhost:8080/sayhello
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("yo, I got called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstname");
        int som = 0;
        for ( int i = 0; i<=5; i++){
            som+= (int) (Math.random()*6+1);
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.println("<!DOCTYPE html>" +
                "<html>"+"<title>Welcome to our servlet!</title>");
        out.println("<body>");
        out.println("<h2 style=\"color:red\">Welcome "+name+"</h2>");
        out.println("The sum of throws equals: "+som);
        out.println("</body");
        out.println("</html>");
    }
}
