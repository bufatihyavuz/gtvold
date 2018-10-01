package com.gametopvideos.repository;

import com.gametopvideos.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RoleDao extends CrudRepository<RoleEntity,String>,Serializable {
}
