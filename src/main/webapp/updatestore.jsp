<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StoreDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Store Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Store</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>

<br>
<div class="main">

<%StoreDTO s = (StoreDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/store/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="store">Numero pezzi di ricambio</label>
    </div>
    <div class="col-75">
      <input type="number" id="store" name="number_spareparts" value=<%=s.getNumber_spareparts()%>>
    </div>
    <input type="hidden" name="id" value =<%=s.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>