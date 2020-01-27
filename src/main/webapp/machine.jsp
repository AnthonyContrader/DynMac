<%@ page import="it.contrader.dto.MachineDTO" 
		 import="it.contrader.dto.DepartmentDTO" 
		 import="java.util.*"
		 %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Machine Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<MachineDTO> list = (List<MachineDTO>) request.getSession().getAttribute("list");
			List<DepartmentDTO> departmentlist = (List<DepartmentDTO>) request.getSession().getAttribute("departmentlist");
		
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Number Sensor</th>
				<th>ID Department</th>
			
			</tr>
			<%
				for (MachineDTO m : list) { %>
			
			<tr>
				<td><a href="/machine/read?id=<%=m.getId()%>"> <%=m.getName()%>
				</a></td>
				<td><%=m.getNumber_sensor()%></td>
				<td><%=m.getDepartmentDTO().getName()%></td>
			
				<td>   </td>
				<td><a href="/machine/preupdate?id=<%=m.getId()%>">Edit</a></td>			
				
				<td>   </td>
				<td><a href="/machine/delete?id=<%=m.getId()%>">Delete</a></td>
				
			</tr>
			<%
				}
			%>
		
		</table>	
			


		<form id="floatright" action="/machine/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="machine">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="machine" name="name"
						placeholder="inserisci nome macchina">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="number_sensor">Number Sensors</label>
				</div>
				<div class="col-75">
					<input type="number" id="number_sensor" name="number_sensor"
						placeholder="inserisci numero sensori">
				</div>
			</div>
				<div class="row">
				
					<div class="col-25">
					<label for="department">ID Department</label>
				</div>
				
				<div class="col-75">					
					<select id="department" name="idDepartment">
						<%for (DepartmentDTO d : departmentlist) { %>
						<option value='<%=d.getId()%>'><%=d.getName() %></option>
						<% } %>
					</select>				
				</div>
			 </div>
					
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>