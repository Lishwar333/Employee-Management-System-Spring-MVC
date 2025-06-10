<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Employee List</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />


</head>
<body>
  <div class="wrapper">
    <header>
      <h1>Employee Management System</h1>
      <nav>
        <a href="${pageContext.request.contextPath}/">Home</a> |
        <a href="${pageContext.request.contextPath}/add">Add Employee</a>
      </nav>
    </header>

    <main>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="employee" items="${employeeList}">
            <tr>
              <td>${employee.id}</td>
              <td>${employee.name}</td>
              <td>${employee.department}</td>
              <td>${employee.email}</td>
              <td>
                <a href="${pageContext.request.contextPath}/edit?id=${employee.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/delete?id=${employee.id}" onclick="return confirm('Are you sure?')">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

      <div class="pagination">
        <c:if test="${page > 1}">
          <a href="?page=${page - 1}">Prev</a>
        </c:if>
        Page ${page} of ${totalPages}
        <c:if test="${page < totalPages}">
          <a href="?page=${page + 1}">Next</a>
        </c:if>
      </div>
    </main>

    <footer>
      <p>© 2025 Employee Management System. All rights reserved.</p>
    </footer>
  </div>
</body>
</html>