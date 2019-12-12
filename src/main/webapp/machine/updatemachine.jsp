<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MachineDTO"%>
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

<%MachineDTO m = (MachineDTO) request.getAttribute("dto");%>


<form id="floatleft" action="MachineServlet?mode=update&id=<%=m.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="machine" name="name" value=<%=m.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="number_sensor">Numero sensori</label>
    </div>
    <div class="col-75">
      <input type="number" id="number_sensor" name="number_sensor" value=<%=m.getNumber_sensors()%>> 
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