package com.gametopvideos.service;

import com.gametopvideos.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserService extends CrudRepository<UserEntity,String>,Serializable {
}
