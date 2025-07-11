package com.jayraj.employee.service;

import com.jayraj.employee.dto.DepartmentDTO;
import com.jayraj.employee.dto.EmployeeDTO;
import com.jayraj.employee.entity.Department;
import com.jayraj.employee.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DepartmentDTO convertToDTO(Department dept) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(dept.getId());
        dto.setName(dept.getName());
        dto.setLocation(dept.getLocation());
        dto.setEmployees(
            dept.getEmployees() == null ? List.of() :
            dept.getEmployees().stream().map(emp -> {
                EmployeeDTO e = new EmployeeDTO();
                e.setId(emp.getId());
                e.setName(emp.getName());
                e.setEmail(emp.getEmail());
                e.setPosition(emp.getPosition());
                e.setSalary(emp.getSalary());
                e.setDepartmentId(dept.getId());
                return e;
            }).collect(Collectors.toList())
        );
        return dto;
    }
}
