<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PurchaseOrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Order</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>

<br>
<div class="main">

<%PurchaseOrderDTO o = (PurchaseOrderDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/purchaseorder/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="order">Nome pezzi di ricambio</label>
    </div>
    <div class="col-75">
      <input type="text" id="order" name="name_spareparts" value=<%=o.getName_spareparts()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="order">Descrizione</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="description" value=<%=o.getDescription()%>> 
    </div>
     <div class="row">
    <div class="col-25">
     <label for="order">Numero pezzi di ricambio</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="number_PiecesToOrder" name="number_PiecesToOrder" value=<%=o.getNumber_PiecesToOrder()%>> 
    </div>
    
    <input type="hidden" name="id" value =<%=o.getId()%>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>