package thais.matera.dia7.plano_de_conta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContas, UUID> {

}
