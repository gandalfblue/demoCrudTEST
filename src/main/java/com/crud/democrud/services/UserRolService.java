package com.crud.democrud.services;

import com.crud.democrud.models.UserRol;

import com.crud.democrud.repositories.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/*
    Clase que representa los servicios crud para la entidad userRol
 */
@Service
public class UserRolService {

    @Autowired
    UserRolRepository usuarioRolRepository;

    /*
        Metodo que sirve para obtener todos los roles que estan almacenados en la base de datos
     */
    public ArrayList<UserRol> obtenerRol() {
        return (ArrayList<UserRol>) usuarioRolRepository.findAll();
    }

    /*
        Metodo que sirve para guardar un rol en la base de datos
     */
    public UserRol guardarRol(UserRol rol) {
        return usuarioRolRepository.save(rol);
    }

    /*
        Metodo que me permite obtener un solo rol por medio del id en la base de datos
     */
    public Optional<UserRol> obtenerPorId(Long id) {
        return usuarioRolRepository.findById(id);
    }

    /*
        Metodo que me permite eliminar un solo rol por medio del id en la base de datos.
     */
    public boolean eliminarRol(Long id) {
        try {
            usuarioRolRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    /*
        Metodo que me permite actualizar un solo rol por medio del id en la base de datos.
     */
    public UserRol updateRoles(long id, UserRol rol) {
        rol.setIdrol(id);
        return usuarioRolRepository.save(rol);
    }
}
