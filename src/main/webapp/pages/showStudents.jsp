<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
        <%@ page import="utility.*" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Show Students</title>
                <link rel="stylesheet" href="css/table.css" />
                <link rel="stylesheet" href="css/common.css" />
            </head>

            <body>
                <table>
                    <tr>
                        <th>RollNo</th>
                        <th>Name</th>
                        <th>Class and Section</th>
                        <th>Date of Birth</th>
                        <th>Address</th>
                        <th>Contactno</th>
                    </tr>
                    <%
        String query = "select * from students";

        //load the driver
        try{
            Jdbc jd = new Jdbc();
            ResultSet rs = jd.getStatement().executeQuery(query);
            while(rs.next()){
				out.print("<tr><td>"+ rs.getString("rollno") +"</td>");
				out.print("<td>"+ rs.getString("name") +"</td>");
				out.print("<td>"+ rs.getString("class") +"</td>");
				out.print("<td>"+ rs.getString("dob") +"</td>");
				out.print("<td>"+ rs.getString("address") +"</td>");
				out.print("<td>"+ rs.getString("contactno") +"</td>");
				out.print("<td><form action='editstudent' method='post'><input type='hidden' name='rollno' value='" + rs.getString("rollno") + "' /><input style='cursor: pointer; background: #ff9999;' type='submit' value='EDIT' /></form></td></tr>");
			}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		%>
                </table>
            </body>

            </html>