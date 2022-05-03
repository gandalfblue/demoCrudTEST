package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.repositories.UserRolRepository;
import com.crud.democrud.services.UserRolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/*
    Clase que me permite realizar pruebas unitarias a la clase service de la entidad rol medinate Mockito
 */
@SpringBootTest
public class UsuarioRolServiceMockTest {

        @MockBean
        UserRolRepository usuarioRolRepository;

        @Autowired
        UserRolService usuarioRolService;

        /*
            Metodo el cual me verifica el funcionamiento de la clase service al realizar una prueba para
                traerme todos los roles.
         */
        @Test
        public void testUserRol() {
            when(usuarioRolRepository.findAll()).thenReturn(new ArrayList<>());
            assertThat(usuarioRolService.obtenerRol()).isEmpty();
            verify(usuarioRolRepository).findAll();
        }

}
