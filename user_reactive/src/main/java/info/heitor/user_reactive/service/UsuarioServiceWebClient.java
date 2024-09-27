package info.heitor.user_reactive.service;

import info.heitor.user_reactive.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceWebClient {

    private final WebClient webClient;

    public UsuarioServiceWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/usuarios").build();
    }

    public Flux<Usuario> listarTodosUsuarios() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Usuario.class);
    }

    public Mono<Usuario> buscarPorId(Long id) {
        return webClient.get()
                .uri("/{id}",id)
                .retrieve()
                .bodyToMono(Usuario.class);
    }

    public Mono<Usuario> salvarUsuario(Usuario usuario) {
        return webClient.post()
                .bodyValue(usuario)
                .retrieve()
                .bodyToMono(Usuario.class);
    }
}
