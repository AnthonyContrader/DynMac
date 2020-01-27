<%@ page import="it.contrader.dto.SensorDTO" 
	     import="it.contrader.dto.StoreDTO" 
	     import="it.contrader.dto.MachineDTO"
	     import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Sensor Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<SensorDTO> list = (List<SensorDTO>) request.getSession().getAttribute("list");
			List<StoreDTO> storelist = (List<StoreDTO>) request.getSession().getAttribute("storelist");
			List<MachineDTO> machinelist = (List<MachineDTO>) request.getSession().getAttribute("machinelist");
		%>
		
		<%SensorDTO sensor = (SensorDTO) request.getSession().getAttribute("dto");%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Durata sensore</th>
				<th>ID Store</th>
				<th>ID Machine</th>
			
			</tr>
			<%
				for (SensorDTO s : list) {
			%>
			<tr>
				<td><a href="/sensor/read?id=<%=s.getId()%>"> <%=s.getName()%>
				</a></td>
				<td><%=s.getLifetime()%></td>
				<td><%=s.getStoreDTO().getName()%></td>
				<td><%=s.getMachineDTO().getName()%></td>
		
				<td> </td>
				<td><a href="/sensor/preupdate?id=<%=s.getId()%>">Edit</a></td>
				
				<td> </td>
				<td><a href="/sensor/delete?id=<%=s.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/sensor/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="sensor">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="machine" name="name"
						placeholder="inserisci nome sensore">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lifetime">Tempo di vita del sensore</label>
				</div>
				<div class="col-75">
					<input type="number" id="lifetime" name="lifetime"
						placeholder="inserisci tempo di vita del sensore">
				</div>
				</div>
			<div class="row">
				<div class="col-25">
					<label for="store">ID Store</label>
				</div>
				
				<div class="col-75">					
					<select id="store" name="idStore">
						<%for (StoreDTO s : storelist) { %>
						<option value='<%=s.getId()%>'><%=s.getName() %></option>
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
		   	  <input type="hidden" name="id" value =<%=sensor.getId() %>>
		    </div>
			
			<button type="submit">Edit</button>
		
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>