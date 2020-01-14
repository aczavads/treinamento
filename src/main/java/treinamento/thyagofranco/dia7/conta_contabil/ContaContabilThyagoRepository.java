package treinamento.thyagofranco.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabilThyagoRepository extends JpaRepository<ContaContabilThyago, UUID>{
	
	@Query(nativeQuery = true, value = "select count(*) from conta_contabil_thyago")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabil_thyago c where c.conta_superior_id is null")
	List<ContaContabilThyago> selecionarContasRaiz();
	
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
	
}

