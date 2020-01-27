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
import it.contrader.dto.OperatorDTO;
import it.contrader.service.DepartmentService;
import it.contrader.service.MachineService;
import it.contrader.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class OperatorController {

	@Autowired
	private OperatorService service;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private MachineService machineService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "operator";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "operator";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateoperator";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("type") String type, 
			@RequestParam("idDepartment") Long idDepartment,
			@RequestParam("idMachine") Long idMachine) {

		OperatorDTO dto = new OperatorDTO();
		DepartmentDTO d = departmentService.read(idDepartment);
		MachineDTO m = machineService.read(idMachine);
		dto.setId(id);
		dto.setName(name);
		dto.setType(type);
		dto.setDepartmentDTO(d);
		dto.setMachineDTO(m);
		service.update(dto);
		setAll(request);
		return "operator";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam("type") String type,
			@RequestParam("idDepartment") Long idDepartment,
			@RequestParam("idMachine") Long idMachine) {
		OperatorDTO dto = new OperatorDTO();
		DepartmentDTO d = departmentService.read(idDepartment);
		MachineDTO m = machineService.read(idMachine);
		dto.setName(name);
		dto.setType(type);
		dto.setDepartmentDTO(d);
		dto.setMachineDTO(m);
		service.insert(dto);
		setAll(request);
		return "operator";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readoperator";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("operatorlist", service.getAll());
		request.getSession().setAttribute("departmentlist", departmentService.getAll());
		request.getSession().setAttribute("machinelist", machineService.getAll());
		
	}
}
