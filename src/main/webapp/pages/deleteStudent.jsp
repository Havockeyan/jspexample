<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Delete Student</title>
        <link rel="stylesheet" href="css/formstyle.css" />
        <link rel="stylesheet" href="css/common.css" />
    </head>

    <body>
        <form action="datadeletestudent" method="post">
            <label>Enter the name you need to delete:</label>
            <input type="text" name="name" required/>
            <label>Enter the rollno you need to delete:</label>
            <input type="text" name="rollno" required/><br/>
            <input class="button" type="submit" value="DELETE User" />
        </form>
    </body>

    </html>