package com.gametopvideos.repository;

import com.gametopvideos.entity.ActionEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ActionDao extends CrudRepository<ActionEntity,String>,Serializable {
}
