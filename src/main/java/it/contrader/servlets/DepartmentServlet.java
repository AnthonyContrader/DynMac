package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.DepartmentDTO;
import it.contrader.service.Service;
import it.contrader.service.DepartmentService;

public class DepartmentServlet extends HttpServlet {

	/*
	 * Per dettagli vedi Guida sez Servlet
	 */
		private static final long serialVersionUID = 1L;

		public DepartmentServlet() {
		}
		
		public void updateList(HttpServletRequest request) {
			Service<DepartmentDTO> service = new DepartmentService();
			List<DepartmentDTO>listDTO = service.getAll();
			request.setAttribute("list", listDTO);
		}

		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Service<DepartmentDTO> service = new DepartmentService();
			String mode = request.getParameter("mode");
			DepartmentDTO dto;
			int id;
			String name;
			int number_operators;
			boolean ans;

			switch (mode.toUpperCase()) {

			case "DEPARTMENTLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/department/departmentmanager.jsp").forward(request, response);
				break;

			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
				
				if (request.getParameter("update") == null) {
					 getServletContext().getRequestDispatcher("/department/readdepartment.jsp").forward(request, response);
					
				}
				
				else getServletContext().getRequestDispatcher("/department/updatedepartment.jsp").forward(request, response);
				
				break;

			case "INSERT":
				name = request.getParameter("name").toString();
				number_operators = Integer.parseInt(request.getParameter("number_operators").toString());
				
				dto = new DepartmentDTO (name, number_operators);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/department/departmentmanager.jsp").forward(request, response);
				break;
				
			case "UPDATE":
				name = request.getParameter("name");
				number_operators = Integer.parseInt(request.getParameter("number_operators"));
				id = Integer.parseInt(request.getParameter("id"));
				dto = new DepartmentDTO (id,name, number_operators);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/department/departmentmanager.jsp").forward(request, response);
				break;


			case "DELETE":
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/department/departmentmanager.jsp").forward(request, response);
				break;
			}
		}
	}
