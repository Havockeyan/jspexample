<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Create Student</title>
        <link href="css/formstyle.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/common.css" />
    </head>

    <body>
        <form id="studentform" action="datacreatestudent" method="POST">
            <label>Name:</label>
            <input type="text" name="name" required/><br/>
            <label>RollNo:</label>
            <input type="text" name="rollno" required/> <br/>
            <label>class and section</label>
            <input type="text" name="class" required/><br/>
            <label>Date of Birth</label>
            <input type="date" name="dob" required/><br/>
            <label>Address</label>
            <input type="text" name="address" required><br/>
            <label>Contactno:</label>
            <input type="text" name="contact" required><br/>
            <input class="button" type="submit" value="Create User" />
        </form>
    </body>

    </html>