package com.gametopvideos.service;

import com.gametopvideos.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface CategoryService extends CrudRepository<CategoryEntity,String>,Serializable {
}
