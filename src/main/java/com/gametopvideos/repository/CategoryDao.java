package com.gametopvideos.repository;

import com.gametopvideos.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface CategoryDao extends CrudRepository<CategoryEntity,String>,Serializable {
}
