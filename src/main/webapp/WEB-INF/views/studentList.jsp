<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="your.package.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Student List</h1>

    <table>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Department</th>
            <th>Mark</th>
        </tr>
        <%
            List<Student> students = your.package.StudentData.getStudents(); // Replace with your data retrieval logic
            int totalStudents = students.size();
            int totalPassStudents = 0;

            for (Student student : students) {
                if (student.getMark() >= 40) {
                    totalPassStudents++;
                }
        %>
            <tr>
                <td><%= student.getStudentID() %></td>
                <td><%= student.getStudentName() %></td>
                <td><%= student.getDepartment() %></td>
                <td><%= student.getMark() %></td>
            </tr>
        <%
            }
            double passPercentage = (double) totalPassStudents / totalStudents * 100;
        %>
    </table>

    <p>Total Pass Percentage: <%= passPercentage %> %</p>

    <script>
        $(document).ready(function() {
            // Your jQuery validation logic here
        });
    </script>
</body>
</html>
