package com.example.employeeservice.controller;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.error.DeleteRequestException;
import com.example.employeeservice.error.EmployeeNotFoundException;
import com.example.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee/")
public class EmployeeController implements BaseController<Employee, Long>{
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
         employeeService.save(employee);
         return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Employee employee) throws Exception {
       try {
            employeeService.update(employee);
            return ResponseEntity.ok("Employee information has been updated successfully");
       }catch (Exception e){
           return ResponseEntity.unprocessableEntity().body(e.getMessage());
       }
    }

    @Override
    public ResponseEntity<String> deleteByIds(@PathVariable("ids") Long... ids) throws DeleteRequestException {
        try {
            employeeService.deleteByIds(ids);
            return ResponseEntity.ok("ID "+ Arrays.toString(ids) + " has been deleted successfully");
        }catch (Exception ex){
            throw new DeleteRequestException("Error deleting employee with id " + Arrays.toString(ids));
        }
    }

    @Override
    public ResponseEntity<Employee> getDataById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
       try {
           Employee employee = employeeService.getDataById(id);
           return ResponseEntity.ok(employee);
       }catch (Exception exception){
           throw new EmployeeNotFoundException("Employee Not Found");
       }
    }

    @Override
    public List<Employee> getData() {
        return employeeService.getData();
    }
}
