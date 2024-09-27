package info.heitor.concessionaria_service.repository;

import info.heitor.concessionaria_service.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
