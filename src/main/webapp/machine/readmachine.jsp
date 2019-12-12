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
<%@ include file="../css/header.jsp" %>
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