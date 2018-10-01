package com.gametopvideos.service;

import com.gametopvideos.entity.ActiontypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ActionTypeService extends CrudRepository<ActiontypeEntity,String>,Serializable {
}
