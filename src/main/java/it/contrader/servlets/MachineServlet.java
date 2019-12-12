package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.MachineDTO;
import it.contrader.service.Service;
import it.contrader.service.MachineService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class MachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MachineServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<MachineDTO> service = new MachineService();
		List<MachineDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MachineDTO> service = new MachineService();
		String mode = request.getParameter("mode");
		int id;
		int number_sensor;
		boolean ans;
		MachineDTO dto;

		switch (mode.toUpperCase()) {

		case "MACHINELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/machine/machinemanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/machine/readmachine.jsp").forward(request, response);
	        }
			
			else getServletContext().getRequestDispatcher("/machine/updatemachine.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			number_sensor = Integer.parseInt(request.getParameter("number_sensor").toString());	
			dto = new MachineDTO (name, number_sensor);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/machine/machinemanager.jsp").forward(request, response);	
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			number_sensor = Integer.parseInt(request.getParameter("number_sensor"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new MachineDTO (id,name,number_sensor);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/machine/machinemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/machine/machinemanager.jsp").forward(request, response);
			break;
		}
	}
}