
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ReportDTO" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Report</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<br>

	<div class="main">

				<table>
			<tr>
				<th></th>
				<th>NETTO precedente</th>
				<th>Produzione totale</th>
				<th>Differenza</th>
				<th>Scarto</th>
				<th>NETTO attuale</th>
				<th>Percentuale realizzativa</th>
				<th>ID Operatore</th>
				<th>ID Machine</th>
				
			</tr>
		
		</table>

	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>