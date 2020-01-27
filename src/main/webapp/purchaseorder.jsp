<%@ page import="it.contrader.dto.PurchaseOrderDTO" 
		 import="it.contrader.dto.StoreDTO"  
         import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Order Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<PurchaseOrderDTO> list = (List<PurchaseOrderDTO>) request.getSession().getAttribute("list");
			List<StoreDTO> storelist = (List<StoreDTO>) request.getSession().getAttribute("storelist");
		%>

		<br>

		<table>
			<tr>
				<th>Nome pezzi di ricambio</th>
				<th>Descrizione</th>
				<th>Numero pezzi da ordinare</th>
				<th>Id Store</th>
			     
			</tr>
			<%
				for (PurchaseOrderDTO o : list) {
			%>
			<tr>
				<td><a href="/purchaseorder/read?id=<%=o.getId()%>"> <%=o.getName_spareparts()%>
				</a></td>
				<td><%=o.getDescription()%></td>
				<td><%=o.getNumber_PiecesToOrder()%></td>
				<td><%=o.getStoreDTO().getName()%></td>
		
				<td>   </td>
				<td><a href="/purchaseorder/preupdate?id=<%=o.getId()%>">Edit</a></td>

				<td>   </td>
				<td><a href="/purchaseorder/delete?id=<%=o.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/purchaseorder/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="order">Nome pezzi di ricambio</label>
				</div>
				<div class="col-75">
					<input type="text" id="order" name="name_spareparts"
						placeholder="inserisci nome pezzo di ricambio">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="order">Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="description" name="description"
						placeholder="inserisci descrizione">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="order">Numero pezzi da ordinare</label>
				</div>
				<div class="col-75">
					<input type="text" id="number_PiecesToOrder" name="number_PiecesToOrder"
						placeholder="inserisci numero pezzi da ordinare">
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
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>