<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OperatorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Operator</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>

<div class="main">
<%OperatorDTO o = (OperatorDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Tipo Operatori</th>
	</tr>
	<tr>
		<td><%=o.getName()%></td>
		<td><%=o.getType()%></td>
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