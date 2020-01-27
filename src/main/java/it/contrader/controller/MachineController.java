package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DepartmentDTO;
import it.contrader.dto.MachineDTO;
import it.contrader.service.DepartmentService;
import it.contrader.service.MachineService;

@Controller
@RequestMapping("/machine")
public class MachineController {

	@Autowired
	private MachineService service;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "machine";
		
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "machine";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatemachine";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("number_sensor") int number_sensor, 
			@RequestParam("idDepartment") Long idDepartment) {
		MachineDTO dto = new MachineDTO();
		DepartmentDTO d = departmentService.read(idDepartment);
		dto.setId(id);
		dto.setName(name);
		dto.setNumber_sensor(number_sensor);
		dto.setDepartmentDTO(d);
		service.insert(dto);
		setAll(request);
		return "machine";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("name") String name,
			@RequestParam("number_sensor") int number_sensor, 
			@RequestParam("idDepartment") Long idDepartment) {
		MachineDTO dto = new MachineDTO();
		DepartmentDTO d = departmentService.read(idDepartment);
		dto.setName(name);
		dto.setNumber_sensor(number_sensor);
		dto.setDepartmentDTO(d);
		service.insert(dto);
		setAll(request);
		return "machine";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request,
			@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readmachine";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("departmentlist", departmentService.getAll());
	}
}
