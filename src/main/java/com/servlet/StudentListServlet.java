package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = new ArrayList<>();
        // Populate students with hardcoded data
        // ...

        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/views/studentList.jsp").forward(request, response);
    }
}
