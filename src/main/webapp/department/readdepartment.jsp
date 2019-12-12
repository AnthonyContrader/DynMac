<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DepartmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Department</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>

<div class="main">
<%DepartmentDTO d = (DepartmentDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Numero operatori</th>
	</tr>
	<tr>
		<td><%=d.getName()%></td>
		<td> <%=d.getNumber_operators()%></td>
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