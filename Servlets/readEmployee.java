import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

public class readEmployee extends HttpServlet {

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

    String url= "jdbc:mysql://localhost:3306/employeeshit";
    String user= "root";
    String password= "password";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(url,user,password);
      System.out.println("connection is successfully made" + url);
      String query = "SELECT* FROM employees;";
      Statement statement = connect.createStatement();
      ResultSet result = statement.executeQuery(query);
      ArrayList<Employee> emps = new ArrayList<Employee>();
      while(result.next()){
        emps.add(new Employee(result.getInt("id"),result.getString("name"),result.getString("email"),result.getString("desig"),result.getString("salary"),result.getString("number")));
      }
      httpServletRequest.setAttribute("emps", emps);
      httpServletRequest.getRequestDispatcher("read.jsp").forward(httpServletRequest, httpServletResponse);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    // httpServletResponse.getWriter().print("Hello from servlet");
  }

  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    doGet(httpServletRequest, httpServletResponse);
  }

  public void getEmployees(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
    try {
      doGet(httpServletRequest, httpServletResponse);
    } catch (IOException | ServletException e) {
      e.printStackTrace();
    }
  }
}
