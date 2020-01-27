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
	     %>

		<br>
		
		<table>
		<%for (ReportDTO r : list) { %>
				<%for (OperatorDTO o : operatorlist) { %>
						<%for (MachineDTO m : machinelist) { %>
		
			<tr>
				<th></th>
				<th>NETTO precedente</th>
				<th>Produzione totale</th>
				<th>Differenza</th>
				<th>Scarto</th>
				<th>NETTO attuale</th>
				<th>Percentuale realizzativa</th>
				<th>ID Operatore</th>
				<th>ID Machine</th>
				<th><a href="/report/preupdate?id=<%=r.getId()%>">Edit</a></th>
				<th><a href="/report/delete?id=<%=r.getId()%>">Delete</a></th>
				
			</tr>	
								
			<tr> <td>00:00 - 04:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>04:00 - 08:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>08:00 - 12:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>12:00 - 16:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>16:00 - 20:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>
			<tr> <td>20:00 - 00:00</td> <td> <%=r.getProduction()%> </td> <td> <%=r.getTotalProduction()%> </td>  <td> <%=r.getDifference()%> </td> <td> <%=r.getWaste()%> </td>  <td> <%=r.getNet()%> </td>  <td> <%=r.getCost()%> </td> <td> <%=o.getName()%>  </td>   <td> <%=m.getName()%> </td> </tr>


			<% } %>
		<% } %>
<% } %>
		</table>
		
			<form id="floatright" action="/report/insert" method="post">			
				<div class="row">
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
		    </div>		
		  		
				<div class="row">
				<div class="col-25">
					<label for="machine">ID Operatore</label>
				</div>
				<div class="col-75">
				<select id="operator" name="idOperator">
						<%for (OperatorDTO o : operatorlist) { %>
						<option value='<%=o.getId()%>'><%=o.getName() %></option>
						<% } %>
				</select>			
			    </div>
		    </div>				
		    	    
			<div class="row">
				<div class="col-25">
					<label for="report">Produzione prec.</label>
				</div>
				<div class="col-75">
					<input type="text" id="report" name="production"
						placeholder="inserisci produzione prec.">
				</div>
			</div>		   
		  
			<div class="row">
				<div class="col-25">
					<label for="report">Produzione totale</label>
				</div>
				<div class="col-75">
					<input type="text" name="totalProduction" 
						placeholder="inserisci produzione totale">
				</div>
			</div>	
		  	    
			<div class="row">
				<div class="col-25">
					<label for="report">Differenza</label>
				</div>
				<div class="col-75">
					<input type="text" id="report" name="difference"
						placeholder="inserisci differenza produzione ">
				</div>
			</div>	
			
			<div class="row">
				<div class="col-25">
					<label for="report">Scarto</label>
				</div>
				<div class="col-75">
					<input type="text" id="report" name="waste"
						placeholder="inserisci scarto ">
				</div>
			</div>	
			
			<div class="row">
				<div class="col-25">
					<label for="report">Netto</label>
				</div>
				<div class="col-75">
					<input type="text" id="report" name="net"
						placeholder="inserisci netto ">
				</div>
			</div>	
			
			
			
			
			<button type="submit">Report</button>
		  </form>
			
				
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>