
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MachineDTO" 
							  import="it.contrader.dto.SensorDTO" 
							  import="it.contrader.dto.DepartmentDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Machine</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<br>

	<div class="main">
		<%
			MachineDTO m = (MachineDTO) request.getSession().getAttribute("dto");
	      //DepartmentDTO  d = (DepartmentDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				
			</tr>
		
		    <tr>
				<td><%=m.getId()%></td>
				<td><%=m.getName()%></td>
			</tr>
			
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>