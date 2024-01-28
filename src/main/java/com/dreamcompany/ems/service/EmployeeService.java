package com.dreamcompany.ems.service;

import com.dreamcompany.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployeeDto(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);


    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);

    void deleteEmployee(Long employeeId);
}
