package no.exercise.assignment.service;

import no.exercise.assignment.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {


    EmployeeDto findEmployeeById(Integer personId);
    List<EmployeeDto> allActiveEmployeers();
    Map<String, List<EmployeeDto>> getAllActiveEmployeesByDepartment();
}
