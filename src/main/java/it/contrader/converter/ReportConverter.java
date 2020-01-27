package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ReportDTO;
import it.contrader.model.Report;

@Component
public class ReportConverter extends AbstractConverter<Report, ReportDTO> {
	@Autowired
	private MachineConverter machineConverter;
	@Autowired
	private OperatorConverter operatorConverter;

	@Override
	public Report toEntity(ReportDTO reportDTO) {
		Report report = null;
		report = new Report();
		report.setId(reportDTO.getId());
		if (reportDTO.getProduction() != 0) {
			report.setProduction(reportDTO.getProduction());
		}
		if (reportDTO.getTotalProduction() != 0) {
			report.setTotalProduction(reportDTO.getTotalProduction());
		}
		if (reportDTO.getDifference() != 0) {
			report.setDifference(reportDTO.getDifference());
		}
		if (reportDTO.getNet() != 0) {
			report.setNet(reportDTO.getNet());
		}
		if (reportDTO.getWaste() != 0) {
			report.setWaste(reportDTO.getWaste());
		}
		if (reportDTO.getCost() != 0) {
			report.setCost(reportDTO.getCost());
		}
		if (reportDTO.getMachineDTO() != null) {
			report.setMachine(machineConverter.toEntity(reportDTO.getMachineDTO()));
		}
		if (reportDTO.getOperatorDTO() != null) {
			report.setOperator(operatorConverter.toEntity(reportDTO.getOperatorDTO()));
		}

		return report;
	}

	@Override
	public ReportDTO toDTO(Report report) {
		ReportDTO reportDTO = null;
		reportDTO = new ReportDTO();
		reportDTO.setId(report.getId());
		if (report.getProduction() != 0) {
			reportDTO.setProduction(report.getProduction());
		}
		if (report.getTotalProduction() != 0) {
			reportDTO.setTotalProduction(report.getTotalProduction());
		}
		if (report.getDifference() != 0) {
			reportDTO.setDifference(report.getDifference());
		}
		if (report.getNet() != 0) {
			reportDTO.setNet(report.getNet());
		}
		if (report.getWaste() != 0) {
			reportDTO.setWaste(report.getWaste());
		}
		if (report.getCost() != 0) {
			reportDTO.setCost(report.getCost());
		}
		if (report.getMachine() != null) {
			reportDTO.setMachineDTO(machineConverter.toDTO(report.getMachine()));
		}
		if (report.getOperator() != null) {
			reportDTO.setOperatorDTO(operatorConverter.toDTO(report.getOperator()));
		}

		return reportDTO;
	}
}
