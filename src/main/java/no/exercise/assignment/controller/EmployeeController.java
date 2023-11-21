package no.exercise.assignment.controller;

import no.exercise.assignment.dto.EmployeeDto;
import no.exercise.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{personId}")
    public EmployeeDto fetchEmployeeByPersonId(@PathVariable Integer personId) {
        return employeeService.findEmployeeById(personId);
    }


    @GetMapping("/active")
    public List<EmployeeDto> fetchAllActiveEmployees() {
        return employeeService.allActiveEmployeers();
    }

    @GetMapping("/active/by-department")
    public Map<String,List<EmployeeDto>> fetchActiveEmployeesByDepartment() {
        return  employeeService.getAllActiveEmployeesByDepartment();
    }

}
