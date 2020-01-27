<%@ page import="it.contrader.dto.ReportDTO" 
		 import="it.contrader.dto.MachineDTO" 
		 import="it.contrader.dto.OperatorDTO" 
		 import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Report Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Report Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="main">
		<%
			List<MachineDTO> machinelist = (List<MachineDTO>) request.getSession().getAttribute("machinelist");
			List<ReportDTO> list = (List<ReportDTO>) request.getSession().getAttribute("list");
			List<OperatorDTO> operatorlist = (List<OperatorDTO>) request.getSession().getAttribute("operatorlist");
	     
	     	ReportDTO report = (ReportDTO) request.getSession().getAttribute("dto");  %>

		<br>	
		
		<table>
			<tr>
				<th></th>
				<th>NETTO precedente</th>
				<th>Produzione totale</th>
				<th>Differenza</th>
				<th>Scarto</th>
				<th>NETTO attuale</th>
				<th>Percentuale realizzativa</th>
				<th>ID Operator</th>
				<th>ID Machine</th>
				
			</tr>
			
			<%for (ReportDTO r : list) { %>
				<%for (OperatorDTO o : operatorlist) { %>
						<%for (MachineDTO m : machinelist) { %>
								
			<tr> <td>00:00 - 04:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>04:00 - 08:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>08:00 - 12:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>12:00 - 16:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>16:00 - 20:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>20:00 - 00:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>


			<% } %>
		<% } %>
    <% } %>


<%   	
		for (ReportDTO r : list) {
			for (MachineDTO m : machinelist) {
				for (OperatorDTO o : operatorlist) {
%>

			<tr>
				<td><a href="/report/read?id=<%=r.getId()%>">
				</a></td>
				<td><%=r.getProduction()%></td>
				<td><%=r.getTotalProduction()%></td>
				<td><%=r.getDifference()%></td>
				<td><%=r.getWaste()%></td>
				<td><%=r.getNet()%></td>
				<td><%=r.getDifference()%></td>
				<td><%=r.getCost()%></td>
		
				<td> </td>
				<td><a href="/report/preupdate?id=<%=r.getId()%>">Edit</a></td>
				
				<td> </td>
				<td><a href="/report/delete?id=<%=r.getId()%>">Delete</a></td>

			</tr>
			<%
				}
	    	%>
	    
	    <%
			}
	    %>			
			
		</table>
<form id="floatleft" action="/report/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="order">Netto Precedente</label>
    </div>
    <div class="col-75">
      <input type="text" id="report" name="production" value=<%=r.getProduction()%>>
    </div>
  </div>
 
  <div class="row">
    <div class="col-25">
     <label for="order">Produzione totale</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="description" value=<%=r.getTotalProduction()%>> 
    </div>
    </div>
     <div class="row">
    <div class="col-25">
     <label for="order">Differenza</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="number_PiecesToOrder" name="difference" value=<%=r.getDifference()%>> 
    </div>
    </div>
     <div class="row">
    <div class="col-25">
     <label for="order">Scarto</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="number_PiecesToOrder" name="waste" value=<%=r.getWaste()%>> 
    </div>
    </div>
     <div class="row">
    <div class="col-25">
     <label for="order">Netto Attuale</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="number_PiecesToOrder" name="net" value=<%=r.getNet()%>> 
    </div>
    </div>
     <div class="row">
    <div class="col-25">
     <label for="order">Costi/ Percentuale Realizzativa</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="number_PiecesToOrder" name="cost" value=<%=r.getCost()%>> 
    </div>
    
    <div class="col-25">
					<label for="machine">ID Machine</label>
				</div>
				<div class="col-75">
				<select id="machine" name="idMachine">
						<%for (MachineDTO m : machinelist) { %>
						<option value='<%=m.getId()%>'><%=m.getName() %></option>
						<% } %>
				</select>			
			    </div>
			    
	 <div class="col-25">
					<label for="machine">ID Operator</label>
				</div>
				<div class="col-75">
				<select id="operator" name="idOperator">
						<%for (OperatorDTO o : operatorlist) { %>
						<option value='<%=o.getId()%>'><%=o.getName() %></option>
						<% } %>
				</select>			
			    </div>
    <% } %>
    <input type="hidden" name="id" value =<%=report.getId()%>>

  </div>
      <button type="submit" >Edit</button>

</form>
	
	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>