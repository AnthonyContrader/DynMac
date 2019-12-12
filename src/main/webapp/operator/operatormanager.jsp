<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.OperatorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Operator Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<OperatorDTO> list = (List<OperatorDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>NAME</th>
			<th>TIPO OPERATORI</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OperatorDTO o : list) {
		%>
		<tr>
			<td><a href=OperatorServlet?mode=read&id=<%=o.getId()%>>
					<%=o.getName()%>
			</a></td>
			<td><%=o.getType()%></td>
			<td><a href=OperatorServlet?mode=read&update=true&id=<%=o.getId()%>>Edit</a>
			</td>
			<td><a href=OperatorServlet?mode=delete&id=<%=o.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="OperatorServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="operator" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Tipo Operatori</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="type" placeholder="inserisci tipo operatori"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>