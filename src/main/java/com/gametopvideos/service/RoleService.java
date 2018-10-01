package com.gametopvideos.service;

import com.gametopvideos.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RoleService extends CrudRepository<RoleEntity,String>,Serializable {
}
