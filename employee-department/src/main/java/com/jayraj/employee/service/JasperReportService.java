package com.jayraj.employee.service;

import jakarta.annotation.PostConstruct;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.jayraj.employee.dto.EmployeeDTO;

@Service
public class JasperReportService {

    private JasperReport jasperReport;

    @PostConstruct
    public void init() throws JRException {
        InputStream reportStream = getClass().getResourceAsStream("/reports/employee_report.jrxml");
        if (reportStream == null) {
            throw new JRException("Could not find JRXML file: /reports/employee_report.jrxml");
        }
        this.jasperReport = JasperCompileManager.compileReport(reportStream);
    }

    public byte[] generateEmployeeReport(List<EmployeeDTO> employees) throws JRException {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        HashMap<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
