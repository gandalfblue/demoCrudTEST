package com.crud.democrud.controllers;


import com.crud.democrud.models.UserRol;
import com.crud.democrud.services.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuario/rol")
public class UserRolController {

    @Autowired
    UserRolService usuarioRol;

    @GetMapping()
    public ArrayList<UserRol> obtenerRol() {
        return usuarioRol.obtenerRol();
    }

    @PostMapping()
    public UserRol guardarRol(@RequestBody UserRol rol) {
        return this.usuarioRol.guardarRol(rol);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserRol> obtenerUsuarioRolPorId(@PathVariable(value ="id") Long id) {
        return this.usuarioRol.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarRolPorId(@PathVariable(value ="id") Long id) {
        boolean ok = this.usuarioRol.eliminarRol(id);
        if (ok) {
            return "Se eliminó el rol al usuario";
        } else {
            return "No pudo eliminar el rol al usuario" + id;
        }
    }
    @PutMapping(path = "/{id}")
    public UserRol updateRoles(@PathVariable(value ="id") Long id, @RequestBody UserRol rol){
        return this.usuarioRol.updateRoles(id, rol);
    }
}
