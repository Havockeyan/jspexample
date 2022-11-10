package utility;

import java.sql.*;

public class Jdbc {
    private String username = "root";
    private String password = "Karthi121@1";
    private Connection connection;
    private Statement st;
    private String url = "jdbc:mysql://localhost:3306/StudentManagement";

    public Statement getStatement() {
        return st;
    }

    public Jdbc()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            this.st = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
