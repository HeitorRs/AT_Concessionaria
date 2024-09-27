package info.heitor.user_reactive;

import info.heitor.user_reactive.controller.UsuarioControllerWebClient;
import info.heitor.user_reactive.model.Usuario;
import info.heitor.user_reactive.service.UsuarioServiceWebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(UsuarioControllerWebClient.class)
public class UsuarioControllerWebClientTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private UsuarioServiceWebClient usuarioServiceWebClient;

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario(1L, "Eduardo Lima", "eduardo@example.com");
    }

    @Test
    public void testListarTodosUsuarios() {
        Flux<Usuario> usuariosFlux = Flux.just(usuario);
        Mockito.when(usuarioServiceWebClient.listarTodosUsuarios()).thenReturn(usuariosFlux);

        webClient.get()
                .uri("/webclient/usuarios")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Usuario.class)
                .hasSize(1)
                .contains(usuario);
    }

    @Test
    public void testBuscarUsuarioPorId() {
        Mockito.when(usuarioServiceWebClient.buscarPorId(1L)).thenReturn(Mono.just(usuario));

        webClient.get()
                .uri("/webclient/usuarios/{id}", 1L)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Usuario.class)
                .isEqualTo(usuario);
    }

    @Test
    public void testSalvarUsuario() {
        Usuario novoUsuario = new Usuario(null, "Novo Usuario", "novo@example.com");
        Mockito.when(usuarioServiceWebClient.salvarUsuario(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        webClient.post()
                .uri("/webclient/usuarios")
                .bodyValue(novoUsuario)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Usuario.class)
                .isEqualTo(usuario);
    }
}
