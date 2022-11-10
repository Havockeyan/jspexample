import utility.Jdbc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/datadeletestudent")
public class DeleteStudent extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");
        String query = "delete from students where name='" + name + "' and rollno='" + rollno + "';";
        try{
            Jdbc jd = new Jdbc();
            int affect = jd.getStatement().executeUpdate(query);
            if(affect == 0){
                throw new SQLException();
            }
            response.setContentType("text/html");
            out.print("<script>alert('user Deleted');window.open('http://localhost:8081/StudentManagement','_self');</script>");

        }catch (SQLException e){
            out.print("No Data with name:" + name + " and rollno:" + rollno + " Existed");
            e.printStackTrace();
        }
    }
}
