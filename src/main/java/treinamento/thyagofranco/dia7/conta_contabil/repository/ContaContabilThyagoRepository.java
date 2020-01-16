package treinamento.thyagofranco.dia7.conta_contabil.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.LockModeType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;

public interface ContaContabilThyagoRepository extends JpaRepository<ContaContabilThyago, UUID>{
	
	@Query(nativeQuery = true, value = "select count(*) from conta_contabil_thyago")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabil_thyago c where c.conta_superior_id is null")
	List<ContaContabilThyago> selecionarContasRaiz();
	
	@Query(nativeQuery = true,
			value = "select * from conta_contabil_thyago",
			countQuery = "select count(*) from conta_contabil_thyago")
	Page<ContaContabilThyago> recuperarTodas(Pageable pageable);
	
	@Query(nativeQuery = true,
			value = "select * from conta_contabil_thyago")
	Slice<ContaContabilThyago> recuperarTodasFatiadas(Pageable pageable);
	
	//Limit é o quanto vai trazer, offset e o quanto se vai caminhar até trazer
	@Query(nativeQuery = true,
			value = "select * from conta_contabil_thyago limit :size offset(:page * :size) ")
	List<ContaContabilThyago> recuperarTodasPaginadoManualmente(int page, int size);
	
	
	//Para retornar a query com o novo campo "nivel" precisamos retornar 
	//com um tipo de retorno que aceite qualquer conjunto de campos e valores.
	
	//Podemos criar um DTO específico ou usar uma lista de mapas. Ex:
	//List<Map<String, Object>> recuperarHierarquia();
	
	
	
	@Query(nativeQuery = true, value = "\r\n" + 
			"			WITH RECURSIVE hierarquia(id, nome, conta_superior_id, nivel) AS (\r\n" + 
			"					SELECT id, nome, conta_superior_id, 1 \r\n" + 
			"					FROM conta_contabil_thyago \r\n" + 
			"					WHERE conta_superior_id is null\r\n" + 
			"					UNION ALL\r\n" + 
			"					SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 \r\n" + 
			"					FROM conta_contabil_thyago f, hierarquia \r\n" + 
			"					WHERE f.conta_superior_id = hierarquia.id\r\n" + 
			"					)\r\n" + 
//			"					SELECT * FROM hierarquia")
			"					SELECT cast(id as varchar) as id,nome,cast()* FROM hierarquia")
	List<Map<String, Object>> recuperarHierarquia();

	
	
//	Com DTO DataTransferObject
//	@Query(nativeQuery = true, value = "\r\n" + 
//			"			WITH RECURSIVE hierarquia(id, nome, conta_superior_id, nivel) AS (\r\n" + 
//			"					SELECT id, nome, conta_superior_id, 1 \r\n" + 
//			"					FROM conta_contabil_thyago \r\n" + 
//			"					WHERE conta_superior_id is null\r\n" + 
//			"					UNION ALL\r\n" + 
//			"					SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 \r\n" + 
//			"					FROM conta_contabil_thyago f, hierarquia \r\n" + 
//			"					WHERE f.conta_superior_id = hierarquia.id\r\n" + 
//			"					)\r\n" + 
//			"					SELECT new treinamento.thyagofranco.dia7.conta_contabil.HierarquiaDTO(id, conta_superior_id, nome, nivel) FROM hierarquia")
//	
//	List<HierarquiaThyagoDTO> recuperarHierarquiaDTO();
	
// Em SQL nativo
//	@Query(nativeQuery = true,
//			value = "select cc.* from"
//					+ "conta_contabil_thyago cc"
//					+ "inner join conta_plano_de_contast cpc on cc.id = cpc.conta_contabil_id "
//					+ "where cpc.plano_de_contas_id = :idPlanoDeContas")
//	List<ContaContabilThyago> findContaDoPlanoDeContas(UUID idPlanoDeContas);
	
 	
//	@Lock(LockModeType.PESSIMISTIC_WRITE)  // adiciona um FOR UPDATE na Query NO BANCO, trava o registro até a transação acabar
//	EM JPQL
	@Query(nativeQuery = true,
			value = "select cc from"
					+ "PlanoDeContasT p"
					+ "inner join p.contasContabeis cc "
					+ "where p.id = :idPlanoDeContas")
	List<ContaContabilThyago> findContaDoPlanoDeContas(UUID idPlanoDeContas);

}

