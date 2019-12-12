<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MachineDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Machine</title>
</head>
<body>

<div class="navbar">
  <a href="homeuser.jsp">Home</a>
  <a href="readmachineuser.jsp">Machine</a>
  <a class="active" href="DepartmentServlet?mode=departmentlist">Department</a>
  <a class="active" href="OperatorServlet?mode=operatorlist">Operator</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%MachineDTO m = (MachineDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Numero sensori</th>
	</tr>
	<tr>
		<td><%=m.getName()%></td>
		<td><%=m.getNumber_sensors()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>