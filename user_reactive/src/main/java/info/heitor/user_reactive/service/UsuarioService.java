package info.heitor.user_reactive.service;

import info.heitor.user_reactive.model.Usuario;
import info.heitor.user_reactive.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Flux<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Mono<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Mono<Usuario> salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
