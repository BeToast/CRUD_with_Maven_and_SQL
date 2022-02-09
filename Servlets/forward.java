import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class forward extends HttpServlet {

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    String CRUD = httpServletRequest.getParameter("CRUD");
    if(CRUD.equals("read.jsp")){
      readEmployee e = new readEmployee();
      e.getEmployees(httpServletRequest, httpServletResponse);
    }
    httpServletRequest.getRequestDispatcher(CRUD).forward(httpServletRequest, httpServletResponse);
  }

  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    doGet(httpServletRequest, httpServletResponse);
  }
}
