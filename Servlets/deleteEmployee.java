import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class deleteEmployee extends HttpServlet {

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

    String url= "jdbc:mysql://localhost:3306/employeeshit";
    String user= "root";
    String password= "password";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(url,user,password);
      System.out.println("connection is successfully made" + url);
      String query = "DELETE FROM Employees WHERE id = \'"+httpServletRequest.getParameter("id")+"\';";
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
