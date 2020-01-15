package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContasFS2, UUID> {

}
