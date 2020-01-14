package william.dia7.Conta_Contabilwd;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {

	@Query(nativeQuery = true, value = "select count (*) from conta_contabil")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabil c where c.conta_superior_id is null")
	List<ContaContabil> selecionarContasRaiz(); 
	
	@Query(nativeQuery = true, value = 
			"WITH RECURSIVE hierarquia(id, nome, conta_superior_id, nivel) AS (\r\n" + 
			"SELECT id, nome, conta_superior_id, 1 FROM conta_contabil where conta_superior_id is NULL\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel + 1\r\n" + 
			"FROM conta_contabil f, hierarquia where f.conta_superior_id = hierarquia.id\r\n" + 
			")\r\n" + 
			"SELECT * FROM hierarquia"
			)
	List<Map<String, Object>> recuperarHierarquia();
}
