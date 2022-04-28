package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    public UserRol() {
    }

    public UserRol(String rol) {
        this.rol = rol;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UsuarioModel.class, optional = false)
    @JoinColumn(name = "userRol_idrol", nullable = false)
    @JsonBackReference
    private UsuarioModel usuario;

    public Long getIdrol() {
        return idrol;
    }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
