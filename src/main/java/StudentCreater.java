import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import utility.Jdbc;

@WebServlet("/datacreatestudent")
public class StudentCreater extends HttpServlet {
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
            out.print("<script>alert('the contact number is not correct');window.open('http://localhost:8081/StudentManagement/createstudent','_self');</script>");
            return;
        }
        for(int i=0;i<contact.length();i++){
            if(!(contact.charAt(i) >= '0' && contact.charAt(i) <='9')){
                response.setContentType("text/html");
                out.print("<script>alert('the contact number is not correct');window.open('http://localhost:8081/StudentManagement/createstudent','_self');</script>");
                return;
            }
        }
        String query = "insert into students values('"+ rollno + "',' " + name +"','" + clas + "','" + date + "','" + address + "','" + contact + "')";


        try{
            Jdbc jd = new Jdbc();
            int affect = jd.getStatement().executeUpdate(query);
            System.out.println(affect + "✋");
            response.setContentType("text/html");
            out.print("<script>alert('user created');window.open('http://localhost:8081/StudentManagement','_self');</script>");
        } catch (SQLException e) {

            out.print("the user already existed");
        }

    }
}
