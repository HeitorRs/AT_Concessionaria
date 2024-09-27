package info.heitor.user_reactive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor@NoArgsConstructor@Data@Builder
@Table(name = "usuarios")
public class Usuario {
    @Id
    private Long id;
    private String nome;
    private String email;
}
