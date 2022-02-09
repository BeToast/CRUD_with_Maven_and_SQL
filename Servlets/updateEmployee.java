import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class updateEmployee extends HttpServlet {

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

    String url= "jdbc:mysql://localhost:3306/employeeshit";
    String user= "root";
    String password= "password";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(url,user,password);
      System.out.println("connection is successfully made" + url);
      String query = "UPDATE employees SET";
      String temp = httpServletRequest.getParameter("id");
      if(!temp.isEmpty())
        query+=" id = \'"+temp+"\',";
      temp = httpServletRequest.getParameter("name");
      if(!temp.isEmpty())
        query+=" name = \'"+temp+"\',";
      temp = httpServletRequest.getParameter("email");
      if(!temp.isEmpty())
        query+=" email = \'"+temp+"\',";
      temp = httpServletRequest.getParameter("desig");
      if(!temp.isEmpty())
        query+=" desig = \'"+temp+"\',";
      temp = httpServletRequest.getParameter("salary");
      if(!temp.isEmpty())
        query+=" salary = \'"+temp+"\',";
      temp = httpServletRequest.getParameter("number");
      if(!temp.isEmpty())
        query+=" number = \'"+temp+"\',";
        
      query = query.substring(0,query.length()-1); //removing the last unnesicary comma
      query+=" WHERE id = \'"+httpServletRequest.getParameter("replaceId")+"\';";

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
