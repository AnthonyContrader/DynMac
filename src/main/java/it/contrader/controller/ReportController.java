package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.MachineDTO;
import it.contrader.dto.OperatorDTO;
import it.contrader.dto.ReportDTO;
import it.contrader.service.MachineService;
import it.contrader.service.OperatorService;
import it.contrader.service.ReportService;


	@Controller
	@RequestMapping("/report")
	public class ReportController {

		@Autowired
		private ReportService service;		
		@Autowired
		private MachineService machineService;
		@Autowired
		private OperatorService operatorService;
				

		@GetMapping("/getall")
		public String getAll(HttpServletRequest request) {
			setAll(request);
			return "report";
		}

		@GetMapping("/delete")
		public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
			service.delete(id);
			setAll(request);
			return "report";
		}
		
		@GetMapping("/preupdate")
		public String preUpdate(HttpServletRequest request, 
				@RequestParam("id") Long id) {
			request.getSession().setAttribute("dto", service.read(id));
			return "updatereport";
		}

		@PostMapping("/update")
		public String update(HttpServletRequest request, 
				@RequestParam("id") long id,
				@RequestParam("production") Long production,
				@RequestParam("totalProduction") Long totalProduction,
				@RequestParam("difference") Long difference,
				@RequestParam("net") Long net,
			    @RequestParam("waste") Long waste,
				@RequestParam("cost") int cost,
			    @RequestParam("idMachine") Long idMachine,
				@RequestParam("idOperator") Long idOperator) {

			ReportDTO dto = new ReportDTO();
			dto.setId(id);
			dto.setProduction(production);
			dto.setTotalProduction(totalProduction);
			dto.setDifference(difference);
			dto.setNet(net);
			dto.setWaste(waste);
			dto.setCost(cost);
		
			service.update(dto);
			setAll(request);
			return "report";

		}
		
		@PostMapping("/insert")
		public String insert(HttpServletRequest request,
				   @RequestParam("production") Long production,
				   @RequestParam("totalProduction") Long totalProduction,
				   @RequestParam("difference") Long difference,
				   @RequestParam("net") Long net,
				   @RequestParam("waste") Long waste,
				   @RequestParam("cost") int cost,
				   @RequestParam("idMachine") Long idMachine,
				   @RequestParam("idOperator") Long idOperator) {
			ReportDTO dto = new ReportDTO();
			MachineDTO m = machineService.read(idMachine);
			OperatorDTO o = operatorService.read(idOperator);
		
			dto.setProduction(production);
			dto.setTotalProduction(totalProduction);
			dto.setDifference(difference);
			dto.setNet(net);
			dto.setWaste(waste);
			dto.setCost(cost);
			
			dto.setMachineDTO(m);
			dto.setOperatorDTO(o);
			service.insert(dto);
			setAll(request);
			return "report";
		}

		@GetMapping("/read")
		public String read(HttpServletRequest request, @RequestParam("id") Long id) {
			request.getSession().setAttribute("dto", service.read(id));
			return "readreport";
		}

		@GetMapping("/logout")
		public String logout(HttpServletRequest request) {
			request.getSession().invalidate();
			return "index";
		}

		private void setAll(HttpServletRequest request) {
			request.getSession().setAttribute("list", service.getAll());
			request.getSession().setAttribute("machinelist", machineService.getAll());
			request.getSession().setAttribute("operatorlist", operatorService.getAll());
		}

	}
	
