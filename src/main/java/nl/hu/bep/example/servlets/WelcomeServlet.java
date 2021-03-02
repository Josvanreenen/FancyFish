package nl.hu.bep.example.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/sayhello") //http://localhost:8080/sayhello
public class WelcomeServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(WelcomeServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("yo, I got called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstname");
        int som = 0;
        for ( int i = 0; i<=5; i++){
            som+= new Random().nextInt(6)+1;
        }
        try {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

            out.println("<!DOCTYPE html>" +
                    "<html>" + "<title>Welcome to our servlet!</title>");
            out.println("<body>");
            out.println("<h2 style=\"color:red\">Welcome " + name + "</h2>");
            out.println("The sum of throws equals: " + som);
            out.println("</body");
            out.println("</html>");
        }
        catch (IOException ioException){
            LOG.error("Something awful happened with this response's writer");
            LOG.error(ioException.getMessage());
        }
    }
}
