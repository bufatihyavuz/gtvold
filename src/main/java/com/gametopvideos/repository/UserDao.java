package com.gametopvideos.repository;

import com.gametopvideos.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserDao extends CrudRepository<UserEntity,String>,Serializable {
}
