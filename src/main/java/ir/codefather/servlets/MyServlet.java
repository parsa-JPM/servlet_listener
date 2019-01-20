package ir.codefather.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.setAttribute("user", "parsa");
        String user = (String) context.getAttribute("user");
        context.removeAttribute("user");

        HttpSession session = req.getSession();
        session.invalidate();

        PrintWriter writer = resp.getWriter();
        writer.println("Hi " + user);
    }
}
