<html>
<head>
  <title>Edit Employee</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
  <div class="container">
    <h1>Edit Employee</h1>

    <form method="post" action="${pageContext.request.contextPath}/update">
      <input type="hidden" name="id" value="${employee.id}" />

      <label for="name">Name:</label>
      <input type="text" id="name" name="name" value="${employee.name}" required />

      <label for="department">Department:</label>
      <input type="text" id="department" name="department" value="${employee.department}" required />

      <label for="email">Email:</label>
      <input type="email" id="email" name="email" value="${employee.email}" required />

      <button type="submit">Update</button>
    </form>

    <a class="back-link" href="${pageContext.request.contextPath}/"> Back to Employee List</a>
  </div>
</body>
</html>