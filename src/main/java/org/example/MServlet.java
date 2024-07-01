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

        try (OutputStream os = resp.getOutputStream()) {
            System.out.println("GET method called -> " + LocalDateTime.now());
            String responseMessage;
            if (name != null && surname != null) {
                responseMessage = "Hello, " + name + " " + surname + "!";
            } else {
                responseMessage = "Please provide both name and surname.";
            }
            os.write(responseMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}