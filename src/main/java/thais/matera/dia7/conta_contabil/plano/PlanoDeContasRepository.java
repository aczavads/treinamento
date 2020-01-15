package thais.matera.dia7.conta_contabil.plano;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContas, UUID> {

}
