package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.OperatorDTO;
import it.contrader.service.Service;
import it.contrader.service.OperatorService;

public class OperatorServlet extends HttpServlet {

		/*
		 * Per dettagli vedi Guida sez Servlet
		 */
			private static final long serialVersionUID = 1L;

			public OperatorServlet() {
			}
			
			public void updateList(HttpServletRequest request) {
				Service<OperatorDTO> service = new OperatorService();
				List<OperatorDTO>listDTO = service.getAll();
				request.setAttribute("list", listDTO);
			}

			@Override
			public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Service<OperatorDTO> service = new OperatorService();
				String mode = request.getParameter("mode");
				OperatorDTO dto;
				int id;
				boolean ans;

				switch (mode.toUpperCase()) {

				case "OPERATORLIST":
					updateList(request);
					getServletContext().getRequestDispatcher("/operator/operatormanager.jsp").forward(request, response);
					break;

				case "READ":
					id = Integer.parseInt(request.getParameter("id"));
					dto = service.read(id);
					request.setAttribute("dto", dto);
					
					if (request.getParameter("update") == null) {
						 getServletContext().getRequestDispatcher("/operator/readoperator.jsp").forward(request, response);
						
					}
					
					else getServletContext().getRequestDispatcher("/operator/updateoperator.jsp").forward(request, response);
					
					break;

				case "INSERT":
					String name = request.getParameter("name").toString();
					String type = request.getParameter("type").toString();
					
					dto = new OperatorDTO (name,type);
					ans = service.insert(dto);
					request.setAttribute("ans", ans);
					updateList(request);
					getServletContext().getRequestDispatcher("/operator/operatormanager.jsp").forward(request, response);
					break;
					
				case "UPDATE":
					name = request.getParameter("name");
					type = request.getParameter("type").toString();
					id = Integer.parseInt(request.getParameter("id"));
					dto = new OperatorDTO (id,name, type);
					ans = service.update(dto);
					updateList(request);
					getServletContext().getRequestDispatcher("/operator/operatormanager.jsp").forward(request, response);
					break;

				case "DELETE":
					id = Integer.parseInt(request.getParameter("id"));
					ans = service.delete(id);
					request.setAttribute("ans", ans);
					updateList(request);
					getServletContext().getRequestDispatcher("/operator/operatormanager.jsp").forward(request, response);
					break;
				}
			}
	
}
