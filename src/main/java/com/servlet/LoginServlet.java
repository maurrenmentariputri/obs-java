package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);
            response.sendRedirect("student-list.jsp");
        } else {
            // Invalid login
            response.sendRedirect("login.jsp?error=true");
        }
    }
}

