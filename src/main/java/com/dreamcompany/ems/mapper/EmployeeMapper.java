package com.dreamcompany.ems.mapper;


import com.dreamcompany.ems.dto.EmployeeDTO;
import com.dreamcompany.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAddress(),
                employee.getRole()
                );
    }

    public static Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAddress(),
                employeeDto.getRole()
        );
    }

}
