package treinamento.diegomucheniski.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabilMucheniskiRepository extends JpaRepository<ContaContabilMucheniski, UUID> {
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM CONTA_CONTABIL_MUCHENISKI")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_CONTABIL_MUCHENISKI C WHERE C.CONTA_SUPERIOR_ID IS NULL")
	List<ContaContabilMucheniski> selecionarContasRaiz();
	
	// Retornar uma relação de contas com o seu nível
	@Query(nativeQuery = true, value = "WITH RECURSIVE " + 
			"   hierarquia (id, nome, conta_superior, nivel) AS ( " + 
			"	SELECT id, nome, conta_superior_id, 1  " + 
			"	FROM conta_contabil_mucheniski where conta_superior_id is null " + 
			"	UNION ALL " + 
			"	SELECT filha.id, filha.nome, filha.conta_superior_id, hierarquia.nivel+1 " + 
			"	FROM conta_contabil_mucheniski filha, hierarquia " + 
			"	WHERE filha.conta_superior_id = hierarquia.id " + 
			" ) " + 
			" SELECT * FROM hierarquia ")
	List<Map<String, Object>> selecionarHierarquia();
	/*Para cada campo retornado dessa consulta vai ser feito um put no map com <chave, valor> 
	exemplo <id, valorRetornado>, <nome, valorRetornado> ....List<ContaContabilMucheniski> findByCodigo(String codigo);
	Feito dessa forma porque está genérico e o retorno dessa query não tem um objeto para ser atribuída, então atribuímos
	no Map*/
	
	
}
