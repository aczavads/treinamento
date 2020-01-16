package fernando_santos.treinamento.dia8.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fernando_santos.treinamento.dia8.domain.PlanoDeContas;

public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContas, UUID> {

	@Query(nativeQuery = true, value = "delete "
			                         + "   from contas_contabeis_plano_de_contas "
			                         + "   where conta_contabil_id = :idContaContabil")
	void removeRelacionamentoDaContaDoPlanoDeContas(UUID idContaContabil);

}