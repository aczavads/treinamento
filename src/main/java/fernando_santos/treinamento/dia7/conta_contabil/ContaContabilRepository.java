package fernando_santos.treinamento.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabilRepository extends JpaRepository<ContaContabilFS, UUID> {
	
	@Query(nativeQuery = true, value = "select count(*) from conta_contabilfs")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabilfs c where c.conta_superior_id is null")
	List<ContaContabilFS> selecionarContaRaiz();
	
	@Query(nativeQuery = true, value = 
			"WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) AS (\r\n" + 
			"SELECT id, nome, conta_superior_id, 1 \r\n" + 
			"   FROM conta_contabilfs \r\n" + 
			"   WHERE conta_superior_id is null\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel + 1 \r\n" + 
			"   FROM conta_contabilfs f, hierarquia \r\n" + 
			"   WHERE f.conta_superior_id = hierarquia.id)\r\n" + 
//			"SELECT id, nome, conta_superior_id, nivel FROM hierarquia")
			"SELECT cast(id as varchar) as id, nome, cast(conta_superior_id as varchar) as conta_superior_id, nivel FROM hierarquia")
	List<Map<String, Object>> recuperarHierarquia();

}
