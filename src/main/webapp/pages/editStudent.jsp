<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
        <%@ page import="utility.*" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Edit Student</title>
                <link rel="stylesheet" href="css/formstyle.css" />
                <link rel="stylesheet" href="css/common.css" />
            </head>

            <body>
                <%
                if(request.getParameter("rollno") == null){
                    out.print("You are not allowed to acces this page");
                    response.sendRedirect("/StudentManagement");
                    return;
                }
        String query = "select * from students where rollno='" + request.getParameter("rollno") +"'";
        Jdbc jd = new Jdbc();
        //load the driver

        try{
            ResultSet rs = jd.getStatement().executeQuery(query);
            rs.next();
            String name = rs.getString("name");
            out.print("<form id='studentform' action='dataeditstudent' method='POST'>");
                out.print("<label>Name:</label><input type='text' name='name' value='" + rs.getString("name").trim() + "' required/><br/>");
            out.print("<input type='hidden' name='rollno' value='" + rs.getString("rollno") + "' required/> <br/>");
                
                out.print("<label>class and section</label><input type='text' name='class' value='" + rs.getString("class") + "' required/><br/>");
                
                out.print("<label>Date of Birth</label><input type='date' name='dob' value='" + rs.getString("dob") + "' required/><br/>");
                
                out.print("<label>Address</label><input type='text' name='address' value='" + rs.getString("address") + "' required/><br/>");
                
                out.print("<label>Contactno:</label><input type='text' name='contact' value='" + rs.getString("contactno") + "' required/><br/>");
                out.print("<input class='button' type='submit' value='Edit User' /></form>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

   
    %>
            </body>

            </html>