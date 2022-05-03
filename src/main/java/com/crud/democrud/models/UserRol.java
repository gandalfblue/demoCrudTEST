package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
    Clase que refleja a la identidad de un usuario
 */
@Entity
@Table(name = "userRol")
public class UserRol implements Serializable {

    private  static final Long  serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idrol;

    @Column
    private String rol;

    /*
        Constructor vacio
     */
    public UserRol() {
    }

    /*
        Contructor iniializando el atributo rol
     */
    public UserRol(String rol) {
        this.rol = rol;
    }

    /*
        Relacion Muchos a Uno con la tabla de usuarios
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UsuarioModel.class, optional = false)
    @JoinColumn(name = "userRol_idrol", nullable = false)
    @JsonBackReference
    private UsuarioModel usuario;

    /*
        Metodo Get del atributo idRol
     */
    public Long getIdrol() {
        return idrol;
    }

    /*
        Metodo Set del  atributo idRol
     */
    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    /*
        Metodo Get del atributo rol
     */
    public String getRol() {
        return rol;
    }

    /*
        Metodo set del atributo rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
