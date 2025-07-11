package com.jayraj.employee.controller;

import com.jayraj.employee.dto.EmployeeDTO;
import com.jayraj.employee.service.EmployeeService;
import com.jayraj.employee.service.JasperReportService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final JasperReportService jasperReportService;
    private final EmployeeService employeeService;

    public ReportController(JasperReportService jasperReportService, EmployeeService employeeService) {
        this.jasperReportService = jasperReportService;
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public void generateEmployeeReport(HttpServletResponse response) throws JRException, IOException {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        byte[] pdfReport = jasperReportService.generateEmployeeReport(employees);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=employee_report.pdf");
        response.getOutputStream().write(pdfReport);
    }
}
