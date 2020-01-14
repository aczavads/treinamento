package treinamento.guilhermeperes.dia7.api.conta;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
	
	@Query(nativeQuery = true,
			value="WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) AS (\r\n" + 
					"SELECT id, nome, conta_superior_id, 1 \r\n" + 
					"  FROM conta \r\n" + 
					" WHERE conta_superior_id is null\r\n" + 
					"UNION ALL\r\n" + 
					"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 \r\n" + 
					"  FROM conta f, hierarquia \r\n" + 
					" WHERE f.conta_superior_id = hierarquia.id\r\n" + 
					")\r\n" + 
					"SELECT * FROM hierarquia")
	public List<Map<String, Object>> recuperarHierarquia();
}
