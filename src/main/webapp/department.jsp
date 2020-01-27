<%@ page import="it.contrader.dto.DepartmentDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Department Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Department Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<DepartmentDTO> list = (List<DepartmentDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Number Operators</th>
				
			</tr>
			<%
				for (DepartmentDTO d : list) {
			%>
			<tr>
				<td><a href="/department/read?id=<%=d.getId()%>"> <%=d.getName()%>
				</a></td>
				<td><%=d.getNumber_operators()%></td>
		
				<td>   </td>
				<td><a href="/department/preupdate?id=<%=d.getId()%>">Edit</a></td>

				<td>   </td>
				<td><a href="/department/delete?id=<%=d.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/department/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="department">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="department" name="name"
						placeholder="inserisci nome reparto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="number_operators">Number Operators</label>
				</div>
				<div class="col-75">
					<input type="text" id="number_operators" name="number_operators"
						placeholder="inserisci numero operatori">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>