package com.gametopvideos.repository;

import com.gametopvideos.entity.ActiontypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ActionTypeDao extends CrudRepository<ActiontypeEntity,String>,Serializable {
}
