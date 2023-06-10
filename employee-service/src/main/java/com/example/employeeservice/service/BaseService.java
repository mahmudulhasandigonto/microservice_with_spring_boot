package com.example.employeeservice.service;

import java.util.List;

public interface BaseService<Entity, ID> {
    Entity save(Entity entity);

    Entity update(Entity entity);

    void deleteByIds(ID[] ids);

    Entity getDataById(ID id);

    List<Entity> getData();

}
