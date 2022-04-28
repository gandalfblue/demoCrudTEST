package com.crud.democrud.ServicesTest;

import com.crud.democrud.repositories.UserRolRepository;
import com.crud.democrud.services.UserRolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;


@SpringBootTest
public class UsuarioRolService {

        @MockBean
        UserRolRepository usuarioRolRepository;

        @Autowired
        UserRolService usuarioRolService;

        @Test
        public void testUserRol() {
            when(usuarioRolRepository.findAll()).thenReturn(new ArrayList<>());
            assertThat(usuarioRolService.obtenerRol()).isEmpty();
            verify(usuarioRolRepository).findAll();
        }

}
