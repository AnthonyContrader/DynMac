<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DepartmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Department Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Department</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>

<div class="main">

<%DepartmentDTO d = (DepartmentDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/department/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="department" name="name" value=<%=d.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Numero Operatori</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="number_operators" value=<%=d.getNumber_operators()%>> 
    </div>
    	<input type="hidden" name="id" value =<%=d.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>