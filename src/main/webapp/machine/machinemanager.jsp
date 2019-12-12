<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.MachineDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<MachineDTO> list = (List<MachineDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>NAME</th>
			<th>NUMERO SENSORI</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (MachineDTO m : list) {
		%>
		<tr>
			<td><a href=MachineServlet?mode=read&id=<%=m.getId()%>>
					<%=m.getName()%>
			</a></td>
			<td><%=m.getNumber_sensors()%></td>
			<td><a href=MachineServlet?mode=read&update=true&id=<%=m.getId()%>>Edit</a>
			</td>
			<td><a href=MachineServlet?mode=delete&id=<%=m.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="MachineServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="machine" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Numero Sensori</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="number_sensor" placeholder="inserisci numero sensori"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>