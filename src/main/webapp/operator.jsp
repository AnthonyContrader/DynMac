<%@ page import="it.contrader.dto.OperatorDTO" 
		 import="it.contrader.dto.DepartmentDTO" 
		 import="it.contrader.dto.MachineDTO" 
		 import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Operator Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Operator Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<OperatorDTO> operatorlist = (List<OperatorDTO>) request.getSession().getAttribute("operatorlist");
			List<DepartmentDTO> departmentlist = (List<DepartmentDTO>) request.getSession().getAttribute("departmentlist");
			List<MachineDTO> machinelist = (List<MachineDTO>) request.getSession().getAttribute("machinelist");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Type</th>
				<th>ID Department</th>
				<th>ID Machine</th>
				
			</tr>
			<%
				for (OperatorDTO o : operatorlist) {
			%>
			
			<tr>
				<td><a href="/operator/read?id=<%=o.getId()%>"> <%=o.getName()%>
				</a> </td>
				<td><%=o.getType()%></td> 
				<td><%=o.getDepartmentDTO().getName()%></td>
			    <td><%=o.getMachineDTO().getName()%></td>
				
			    <td> </td>
	
				<td><a href="/operator/preupdate?id=<%=o.getId()%>">Edit</a></td>
				<td>   </td>

				<td><a href="/operator/delete?id=<%=o.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
			
		</table>



		<form id="floatright" action="/operator/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="operator">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="operator" name="name"
						placeholder="inserisci nome operatore">
				</div>
			  </div>
			<div class="row">
				<div class="col-25">
					<label for="type">TYPE</label>
				</div>
				<div class="col-75">
					<select id="type" name="type">
						<option value="Capo">CAPO</option>
						<option value="Operaio">OPERAIO</option>
					</select>
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
				
				<div class="col-25">
					<label for="machine">ID Machine</label>
				</div>
				<div class="col-75">
				<select id="machine" name="idMachine">
						<%for (MachineDTO m : machinelist) { %>
						<option value='<%=m.getId()%>'><%=m.getName() %></option>
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