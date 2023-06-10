package com.example.employeeservice.serviceimplementation;

import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public Employee update(Employee employee) {

        if(employee.hasId()){
            return save(employee);
        }else{
            throw new InvalidDnDOperationException("Employee id has been required for update operation");
        }

    }

    @Override
    public void deleteByIds(Long[] longs) {
        employeeRepository.deleteAllById(Arrays.asList(longs));
    }

    @Override
    public Employee getDataById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getData() {
        return employeeRepository.findAll();
    }
}
