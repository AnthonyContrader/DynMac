<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<div class="header">DynMac
</div>
 <div class="navbar">
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="MachineServlet?mode=machinelist">Machines</a>
  <a class="active" href="DepartmentServlet?mode=departmentlist">Department</a>
  <a class="active" href="OperatorServlet?mode=operatorlist">Operator</a>
  <a class="active" href="LogoutServlet" id="logout">Logout</a>
</div>

</body>
</html>