package info.heitor.user_reactive.repository;

import info.heitor.user_reactive.model.Usuario;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UsuarioRepository extends R2dbcRepository<Usuario, Long> {
}
