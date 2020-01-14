package treinamento.guilhermeperes.dia7.api.conta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
}
