package treinamento.diegomucheniski.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContaContabilMucheniskiRepository extends JpaRepository<ContaContabilMucheniski, UUID> {
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM CONTA_CONTABIL_MUCHENISKI")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_CONTABIL_MUCHENISKI C WHERE C.CONTA_SUPERIOR_ID IS NULL")
	List<ContaContabilMucheniski> selecionarContasRaiz();
	
	@Query(nativeQuery = true, value = " select * from conta_contabil_mucheniski ", countQuery = " select count(*) from conta_contabil_mucheniski ")
	Page<ContaContabilMucheniski> selecionarContasPaginado(Pageable pageable);
	
	
	@Query(nativeQuery = true, value = " select * from conta_contabil_mucheniski ")
	Slice<ContaContabilMucheniski> selecionarContasFatiado(Pageable pageable);
	
		
	// Retornar uma rela��o de contas com o seu n�vel
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
	Feito dessa forma porque est� gen�rico e o retorno dessa query n�o tem um objeto para ser atribu�da, ent�o atribu�mos
	no Map*/
	

	@Query(nativeQuery = true, value = "select * from conta_contabil_mucheniski limit :size offset (:size * :page)")
	List<ContaContabilMucheniski> recuperarTodasContas(@Param("page") int page, @Param("size") int size);
	
	
}
