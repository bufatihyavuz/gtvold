package com.gametopvideos.service;

import com.gametopvideos.entity.ActionEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ActionService extends CrudRepository<ActionEntity,String>,Serializable {
}
