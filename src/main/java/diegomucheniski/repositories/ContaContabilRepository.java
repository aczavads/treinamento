package diegomucheniski.repositories;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import diegomucheniski.domains.ContaContabil;

public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM CONTA_CONTABIL")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_CONTABIL C WHERE C.CONTA_SUPERIOR_ID IS NULL")
	List<ContaContabil> selecionarContasRaiz();
	
	@Query(nativeQuery = true, value = " select * from conta_contabil ", countQuery = " select count(*) from conta_contabil ")
	Page<ContaContabil> selecionarContasPaginado(Pageable pageable);
	
	
	@Query(nativeQuery = true, value = " select * from conta_contabil ")
	Slice<ContaContabil> selecionarContasFatiado(Pageable pageable);
	
		
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
	

	@Query(nativeQuery = true, value = "select * from conta_contabil limit :size offset (:size * :page)")
	List<ContaContabil> recuperarTodasContas(@Param("page") int page, @Param("size") int size);
	
	
}
