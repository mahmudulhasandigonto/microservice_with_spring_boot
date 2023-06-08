package com.example.departmentservice.controller;

import com.example.departmentservice.error.DeleteRequestException;
import com.example.departmentservice.error.DepartmentNotFoundException;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/department/")
@RequiredArgsConstructor
public class DepartmentController implements BaseController<Department, Long>{

    final private DepartmentService departmentService;
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Override
    public ResponseEntity<Department> save(@RequestBody Department department) {
        departmentService.save(department);
        LOGGER.info("Department Save successfully");
        return ResponseEntity.ok(department);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Department department) throws Exception {
        try {
            departmentService.update(department);
            LOGGER.info("Department updated successfully");
            return ResponseEntity.ok("Department information has been updated successfully");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteByIds(@PathVariable("ids") Long... ids) throws DeleteRequestException {
       try {
           departmentService.deleteByIds(ids);
           LOGGER.info("Department has been deleted by Ids={}", ids);
           return ResponseEntity.ok("ID "+ Arrays.toString(ids) + " has been deleted successfully");
       }
       catch (Exception ex){
           throw new DeleteRequestException("Error deleting driver with id "+ Arrays.toString(ids));
       }
    }

    @Override
    public ResponseEntity<Department> getDataById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        try{
            Department department = departmentService.getDataById(id);
            return ResponseEntity.ok(department);
        }catch (Exception e){
            throw new DepartmentNotFoundException("Driver Not Found");
        }
    }

    @Override
    public List<Department> getData() {
        LOGGER.info("Department find");
       return departmentService.getData();
    }
}
