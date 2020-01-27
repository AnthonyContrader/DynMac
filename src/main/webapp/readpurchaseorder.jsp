
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PurchaseOrderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Order</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<br>

	<div class="main">
		<%
			PurchaseOrderDTO o = (PurchaseOrderDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Nome pezzo di ricambio</th>
				<th>Descrizione</th>
				<th>Numero pezzi di ricambio</th>
			
			</tr>
			<tr>
				<td><%=o.getId()%></td>
				<td><%=o.getName_spareparts()%></td>
				<td><%=o.getDescription()%></td>
				<td><%=o.getNumber_PiecesToOrder()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>