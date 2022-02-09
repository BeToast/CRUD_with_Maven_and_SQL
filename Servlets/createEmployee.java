import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class createEmployee extends HttpServlet {

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

    String url= "jdbc:mysql://localhost:3306/employeeshit";
    String user= "root";
    String password= "password";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(url,user,password);
      System.out.println("connection is successfully made" + url);
      String query = "INSERT into employees(id, name, email, desig, salary, number) values("
        +httpServletRequest.getParameter("id")+", \'"
        +httpServletRequest.getParameter("name")+"\', \'"
        +httpServletRequest.getParameter("email")+"\', \'"
        +httpServletRequest.getParameter("desig")+"\', "
        +httpServletRequest.getParameter("salary")+", "
        +httpServletRequest.getParameter("number")+
      ");";
      System.out.println(query);
      connect.createStatement().execute(query);

      httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    doGet(httpServletRequest, httpServletResponse);
  }
}
