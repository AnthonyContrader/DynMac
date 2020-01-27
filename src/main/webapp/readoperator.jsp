<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.OperatorDTO"
							  import="it.contrader.dto.DepartmentDTO"
	                          import="it.contrader.dto.MachineDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Operator</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	
	<br>

	<div class="main">
		<%
			//MachineDTO m = (MachineDTO) request.getSession().getAttribute("dto");
			OperatorDTO o = (OperatorDTO) request.getSession().getAttribute("dto");
			//DepartmentDTO  d = (DepartmentDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Type</th>				
			</tr>
			
			<tr>
				<td><%=o.getId()%></td>
				<td><%=o.getName()%></td>
				<td><%=o.getType()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>