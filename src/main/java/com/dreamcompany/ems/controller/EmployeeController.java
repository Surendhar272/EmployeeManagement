package com.dreamcompany.ems.controller;

import com.dreamcompany.ems.dto.EmployeeDTO;
import com.dreamcompany.ems.mapper.EmployeeMapper;
import com.dreamcompany.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee Rest API
    @PostMapping()
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDto){
        EmployeeDTO savedEmployee = employeeService.createEmployeeDto(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get Employee By Id Rest API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> fetchEmployee(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Get All Employee REST API
    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> fetchAllEmployees(){
        List<EmployeeDTO> employeeDTO = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Update Employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Delete Employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully !!");
    }
}
