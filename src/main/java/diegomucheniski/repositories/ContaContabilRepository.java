package diegomucheniski.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;

import diegomucheniski.base.BaseRepository;
import diegomucheniski.domains.ContaContabil;

public interface ContaContabilRepository extends BaseRepository<ContaContabil> {
	
	// Retornar uma relação de contas com o seu nível
	@Query(nativeQuery = true, value = "WITH RECURSIVE " + 
			"   hierarquia (id, nome, conta_superior, nivel) AS ( " + 
			"	SELECT id, nome, conta_superior_id, 1  " + 
			"	FROM conta_contabil where conta_superior_id is null " + 
			"	UNION ALL " + 
			"	SELECT filha.id, filha.nome, filha.conta_superior_id, hierarquia.nivel+1 " + 
			"	FROM conta_contabil filha, hierarquia " + 
			"	WHERE filha.conta_superior_id = hierarquia.id " + 
			" ) " + 
			" SELECT * FROM hierarquia ")
	List<Map<String, Object>> selecionarHierarquia();
	/*Para cada campo retornado dessa consulta vai ser feito um put no map com <chave, valor> 
	exemplo <id, valorRetornado>, <nome, valorRetornado> ....List<ContaContabilMucheniski> findByCodigo(String codigo);
	Feito dessa forma porque está genérico e o retorno dessa query não tem um objeto para ser atribuída, então atribuímos
	no Map*/	

}
