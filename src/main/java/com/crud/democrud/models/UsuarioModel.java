package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Clae que identifica a la entidad usuario.
 */
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    private  static final Long  serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "email", nullable = false, length = 30)
    private String email;
    @Column(name = "prioridad", nullable = false, length = 10)
    private Integer prioridad;

    /*
        Constructor inicializando todos los atributos excepto el id
     */
    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    /*
        Constructor vacio
     */
    public UsuarioModel() {

    }

    /*
        Relacion Uno a Muchos con la tabla de usuarios
     */
    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = UserRol.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "usuario"
    )
    @JsonManagedReference
    private List<UserRol> userrols = new ArrayList<>();

    /*
        Metodo Set del atributo prioridad
     */
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    /*
        Metodo Get del atributo de prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /*
        Metodo Get del atributo id
     */
    public Long getId() {
        return id;
    }

    /*
        Metodo Set del atributo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /*
        Metodo Get del atributo nombre
     */
    public String getNombre() {
        return nombre;
    }

    /*
        Metodo Set del atributo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
        Metodo Get del atributo email
     */
    public String getEmail() {
        return email;
    }

    /*
        Metodo Set del atributo email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}