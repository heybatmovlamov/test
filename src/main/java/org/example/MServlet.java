package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        resp.setContentType("text/plain");

        try (PrintWriter pw = resp.getWriter()) {
            System.out.println("GET method called -> " + LocalDateTime.now());
            if (name != null && surname != null) {
                pw.write("Hello, " + name + " " + surname + "!");
            } else {
                pw.write("Please provide both name and surname.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}