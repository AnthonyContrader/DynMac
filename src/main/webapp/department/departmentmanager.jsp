<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.DepartmentDTO"%>
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
		List<DepartmentDTO> list = (List<DepartmentDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>NAME</th>
			<th>NUMERO OPERATORI</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (DepartmentDTO d : list) {
		%>
		<tr>
			<td><a href=DepartmentServlet?mode=read&id=<%=d.getId()%>>
					<%=d.getName()%>
			</a></td>
			<td><%=d.getNumber_operators()%></td>
			<td><a href=DepartmentServlet?mode=read&update=true&id=<%=d.getId()%>>Edit</a>
			</td>
			<td><a href=DepartmentServlet?mode=delete&id=<%=d.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="DepartmentServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="department" name="name" placeholder="inserisci nome reparto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Numero Operatori</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="number_operators" placeholder="inserisci numero operatori"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>