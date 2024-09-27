package info.heitor.user_reactive.controller;

import info.heitor.user_reactive.model.Usuario;
import info.heitor.user_reactive.service.UsuarioServiceWebClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient/usuarios")
public class UsuarioControllerWebClient {

    private final UsuarioServiceWebClient usuarioServiceWebClient;

    public UsuarioControllerWebClient(UsuarioServiceWebClient usuarioServiceWebClient) {
        this.usuarioServiceWebClient = usuarioServiceWebClient;
    }

    @GetMapping
    public Flux<Usuario> listarTotosUsuarios() {
        return usuarioServiceWebClient.listarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Mono<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioServiceWebClient.buscarPorId(id);
    }

    @PostMapping
    public Mono<Usuario> salvarUsuario(Usuario usuario) {
        return usuarioServiceWebClient.salvarUsuario(usuario);
    }
}
