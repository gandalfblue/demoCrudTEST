package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
    Clase que me permite realizar pruebas unitarias a la clase service de la entidad usuario medinate Mockito
 */
@SpringBootTest
public class UsuarioServiceMockTest {

  @MockBean
  UsuarioRepository usuarioRepository;

  @Autowired
  UsuarioService usuarioService;

  /*
            Metodo el cual me verifica el funcionamiento de la clase service al realizar una prueba para
                traerme todos los usuarios.
         */
  @Test
  public void testUsuarioMock(){
    when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
    assertThat(usuarioService.obtenerUsuarios()).isEmpty();
    verify(usuarioRepository).findAll();
  }

}
