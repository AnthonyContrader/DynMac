<%@ page import="it.contrader.dto.StoreDTO"  import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Sensor Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Store Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<StoreDTO> list = (List<StoreDTO>) request.getSession().getAttribute("list");
			
		%>

		<br>

		<table>
			<tr>
				<th>Nome </th>
				<th>Numero Pezzi di Ricambio</th>
				<th>Costo sensore </th>
				<th>Totale </th>
			
			</tr>
			<%
				for (StoreDTO s : list) {
			%>
			<tr>
				<td><a href="/store/read?id=<%=s.getId()%>"> <%=s.getName()%> </a> </td>
				<td><%=s.getNumber_spareparts()%></td>
		
				<td> <%=s.getCost()%> </td>
				
				<td> <%=s.getTotCost() %> </td>
				
				<td><a href="/store/preupdate?id=<%=s.getId()%>">Edit</a></td>


				<td><a href="/store/delete?id=<%=s.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/store/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="store">Nome pezzi di ricambio</label>
				</div>
				<div class="col-75">
					<input type="text" id="store" name="name"
						placeholder="inserisci nome pezzi di ricambio">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="store">Numero pezzi di ricambio</label>
				</div>
				<div class="col-75">
					<input type="number" id="store" name="number_spareparts"
						placeholder="inserisci numero pezzi di ricambio">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="store">Costo pz</label>
				</div>
				<div class="col-75">
					<input type="number" id="store" name="cost"
						placeholder="inserisci costo per pz">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="store">Totale</label>
				</div>
				<div class="col-75">
					<input type="number" id="store" name="totCost"
						placeholder="inserisci totale">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>