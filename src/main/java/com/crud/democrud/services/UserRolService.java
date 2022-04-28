package com.crud.democrud.services;

import com.crud.democrud.models.UserRol;

import com.crud.democrud.repositories.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserRolService {

    @Autowired
    UserRolRepository usuarioRolRepository;

    public ArrayList<UserRol> obtenerRol() {
        return (ArrayList<UserRol>) usuarioRolRepository.findAll();
    }

    public UserRol guardarRol(UserRol rol) {
        return usuarioRolRepository.save(rol);
    }

    public Optional<UserRol> obtenerPorId(Long id) {
        return usuarioRolRepository.findById(id);
    }

    public boolean eliminarRol(Long id) {
        try {
            usuarioRolRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public UserRol updateRoles(long id, UserRol rol) {
        rol.setIdrol(id);
        return usuarioRolRepository.save(rol);
    }
}
