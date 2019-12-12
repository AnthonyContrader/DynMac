<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OperatorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%OperatorDTO o = (OperatorDTO) request.getAttribute("dto");%>


<form id="floatleft" action="OperatorServlet?mode=update&id=<%=o.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="machine" name="name" value=<%=o.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Tipo operatori</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="type" value=<%=o.getType()%>> 
    </div>
  </div>
  <div class="row">
  <div class="col-75"> 		 
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>