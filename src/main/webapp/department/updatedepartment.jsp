<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DepartmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">

<%DepartmentDTO d = (DepartmentDTO) request.getAttribute("dto");%>


<form id="floatleft" action="DepartmentServlet?mode=update&id=<%=d.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="department" name="name" value=<%=d.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="number_operators">Numero Operatori</label>
    </div>
    <div class="col-75">
      <input type="number" id="number_operators" name="number_operators" value=<%=d.getNumber_operators() %>> 
    </div>	 		 
  </div>
  <div class="row">
  <div class="col-75"> 	
   </div>	 
   </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>