package com.dreamcompany.ems.service;

import com.dreamcompany.ems.dto.EmployeeDTO;
import com.dreamcompany.ems.entity.Employee;
import com.dreamcompany.ems.exception.ResourceNotFoundException;
import com.dreamcompany.ems.mapper.EmployeeMapper;
import com.dreamcompany.ems.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDTO createEmployeeDto(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapEmployeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with the given Id: "+ employeeId));
        return EmployeeMapper.mapEmployeeToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(EmployeeMapper::mapEmployeeToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with the given Id: "+ employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setRole(updatedEmployee.getRole());
        Employee updateEmployeeObj = employeeRepo.save(employee);
        return EmployeeMapper.mapEmployeeToEmployeeDTO(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with the given Id: "+ employeeId));
        employeeRepo.deleteById(employeeId);
    }
}
