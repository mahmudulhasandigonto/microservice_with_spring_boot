package com.example.departmentservice.serviceImplementaion;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {

        return departmentRepository.save(department);

    }

    @Override
    public Department update(Department department) throws Exception {
     if(department.hasId()){
         return save(department);
     }else{
         throw new InvalidDnDOperationException("Department id has been required for update operation");
     }
    }

    @Override
    public void deleteByIds(Long[] longs) {
        departmentRepository.deleteAllById(Arrays.asList(longs));
    }

    @Override
    public Department getDataById(Long aLong) {
        return departmentRepository.findById(aLong).get();
    }

    @Override
    public List<Department> getData() {
       return departmentRepository.findAll();
    }
}
