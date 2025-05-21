<html>
<head>
  <title>Delete Employee</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
  <h1>Delete Employee</h1>
  <p>Are you sure you want to delete employee: <strong>${employee.name}</strong>?</p>

  <form method="post" action="${pageContext.request.contextPath}/delete">
    <input type="hidden" name="id" value="${employee.id}" />
    <button type="submit">Yes, Delete</button>
    <a href="${pageContext.request.contextPath}/">Cancel</a>
  </form>
</body>
</html>
 