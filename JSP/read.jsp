<html>
<head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <title>Employees</title>
</head>
<body>
  <h2>Employees</h2>
  <table border="1" cellpadding="0" cellspacing="0" width="200px" style="border-collapse:collapse;">
    <thread>
      <tr><td>ID</td><td>Name</td><td>Department</td><td>Desig</td><td>Salary</td><td>Phone</td></tr>
    </thread>
    <c:forEach var="emp" items="${emps}">
      <tr>
        <td>${emp.getId()}</td>
        <td>${emp.getName()}</td>
        <td>${emp.getEmail()}</td>
        <td>${emp.getDesig()}</td>
        <td>${emp.getSalary()}</td>
        <td>${emp.getSalary()}</td>
      </tr>
    </c:forEach>
  </table>
  <br>
  <button onclick="location.href='/src/main/webapp/WEB-INF/index.jsp'">Back to index</button>
</body>
</html>