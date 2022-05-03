package com.crud.democrud.repositories;

import com.crud.democrud.models.UserRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/*
    Interfaz que hereda de la interfaz CrudRepository que tiene SpringBoot, todos sus metodos
 */
@Repository
public interface UserRolRepository extends CrudRepository<UserRol, Long> {

}
