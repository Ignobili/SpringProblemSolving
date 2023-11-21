package no.exercise.assignment.service.implementation;

import no.exercise.assignment.dto.EmployeeDto;
import no.exercise.assignment.repository.EmployeeRepository;
import no.exercise.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto findEmployeeById(Integer personId) {
        return employeeRepository.findByEmployeeId(personId);
    }

    @Override
    public List<EmployeeDto> allActiveEmployeers() {
        return employeeRepository.getActiveEmployees();
    }

    @Override
    public Map<String, List<EmployeeDto>> getAllActiveEmployeesByDepartment() {

        List<EmployeeDto> activeEmployees = employeeRepository.getAllActiveEmployeesByDepartment();

        return  activeEmployees.stream()
                .filter(employeeDto -> employeeDto.departmentName() != null)
                .collect(Collectors.groupingBy(EmployeeDto::departmentName));
    }




}
