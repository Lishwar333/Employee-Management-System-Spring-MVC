<html>
<head>
  <title>Add New Employee</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
  <div class="container">
    <h1>Add New Employee</h1>

    <form method="post" action="${pageContext.request.contextPath}/save">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required />

      <label for="department">Department:</label>
      <input type="text" id="department" name="department" required />

      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required />

      <button type="submit">Save</button>
    </form>

    <a class="back-link" href="${pageContext.request.contextPath}/"> Back to Employee List</a>
  </div>
</body>
</html>