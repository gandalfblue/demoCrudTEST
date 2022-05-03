package com.crud.democrud.services;

import com.crud.democrud.models.UserRol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/*
    Clase que representa los servicios crud para la entidad userRol
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    /*
        Metodo que sirve para obtener todos los usuarios que estan almacenados en la base de datos
     */
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /*
        Metodo que sirve para guardar un usuario en la base de datos
     */
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /*
       Metodo que me permite obtener un solo usuario por medio del id en la base de datos
    */
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    /*
        Metodo que me permite eliminar un solo usuario por medio del id en la base de datos.
     */
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    /*
        Metodo que me permite actualizar un solo usuario por medio del id en la base de datos.
     */
    public UsuarioModel updateUsuario(Long id, UsuarioModel usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }
}