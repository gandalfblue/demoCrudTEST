package com.crud.democrud.repositories;

import com.crud.democrud.models.UserRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRolRepository extends CrudRepository<UserRol, Long> {

}
