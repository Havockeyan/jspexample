import utility.Jdbc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/dataeditstudent")
public class Editstudent extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name").trim();
        String rollno = request.getParameter("rollno").trim();
        String clas = request.getParameter("class").trim();
        String date = request.getParameter("dob").trim();
        String address = request.getParameter("address").trim();
        String contact = request.getParameter("contact").trim();

        //contact number validation
        if(contact.length() != 10){
            response.setContentType("text/html");
            out.print("<script>alert('the contact number is not correct');window.open('http://localhost:8081/StudentManagement/showstudents','_self');</script>");
            return;
        }
        for(int i=0;i<contact.length();i++){
            if(!(contact.charAt(i) >= '0' && contact.charAt(i) <='9')){
                response.setContentType("text/html");
                out.print("<script>alert('the contact number is not correct');window.open('http://localhost:8081/StudentManagement/showstudents','_self');</script>");
                return;
            }
        }
//        String query = "select * from students where rollno='" + rollno + "';";
        String editquery = "update students set name='" + name + "', class='" + clas + "', dob='" + date + "', address='" + address + "', contactno='" + contact + "' where rollno='" + rollno + "';";

        //load the driver
        try{
            Jdbc jd = new Jdbc();
            System.out.print(editquery);
            int affect = jd.getStatement().executeUpdate(editquery);
//            System.out.print("updated");
            response.setContentType("text/html");
            out.print("<script>alert('user Updated');window.open('http://localhost:8081/StudentManagement','_self');</script>");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
