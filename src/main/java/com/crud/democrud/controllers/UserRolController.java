package com.crud.democrud.controllers;


import com.crud.democrud.models.UserRol;
import com.crud.democrud.services.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

/*
    Clase que representa el controlador del backend y se especifican como van a salir los enpoints
 */
@CrossOrigin
@RestController
@RequestMapping("/usuario/rol")
public class UserRolController {

    @Autowired
    UserRolService usuarioRol;

    /*
        Metodo que sirve para enrutarme a la clase service para obtener un get de todos los roles.
    */
    @GetMapping()
    public ArrayList<UserRol> obtenerRol() {
        return usuarioRol.obtenerRol();
    }

    /*
        Metodo que sirve para enrutarme a la clase service para guardar un rol
    */
    @PostMapping()
    public UserRol guardarRol(@RequestBody UserRol rol) {
        return this.usuarioRol.guardarRol(rol);
    }

    /*
        Metodo que sirve para enrutarme a la clase service para obtener un get de un solo rol mediante el id.
    */
    @GetMapping(path = "/{id}")
    public Optional<UserRol> obtenerUsuarioRolPorId(@PathVariable(value ="id") Long id) {
        return this.usuarioRol.obtenerPorId(id);
    }

    /*
        Metodo que sirve para enrutarme a la clase service para borrar un solo rol mediante el id.
    */
    @DeleteMapping(path = "/{id}")
    public String eliminarRolPorId(@PathVariable(value ="id") Long id) {
        boolean ok = this.usuarioRol.eliminarRol(id);
        if (ok) {
            return "Se eliminó el rol al usuario";
        } else {
            return "No pudo eliminar el rol al usuario" + id;
        }
    }

    /*
        Metodo que sirve para enrutarme a la clase service para actualizar un solo rol mediante el id.
    */
    @PutMapping(path = "/{id}")
    public UserRol updateRoles(@PathVariable(value ="id") Long id, @RequestBody UserRol rol){
        return this.usuarioRol.updateRoles(id, rol);
    }
}
