package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabil2Repository extends JpaRepository<ContaContabil2, UUID> {

	@Query(nativeQuery = true, value = "select count(*) from conta_contabil2")
	Long contarContas();

	@Query(nativeQuery = true, value = "select * from conta_contabil2 c where c.conta_superior_id is null")
	List<ContaContabil2> selecionarContasRaiz();

	@Query(nativeQuery = true, value = "WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) AS (\r\n" + 
			"SELECT id, nome, conta_superior_id, 1 \r\n" + 
			"   FROM conta_contabil2 \r\n" + 
			"   WHERE conta_superior_id is null\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel + 1 \r\n" + 
			"   FROM conta_contabil2 f, hierarquia \r\n" + 
			"   WHERE f.conta_superior_id = hierarquia.id)\r\n" + 
			"\r\n" + 
			"SELECT * FROM hierarquia")
	List<Map<String, Object>> selecionarContasPelaHierarquia();

}
