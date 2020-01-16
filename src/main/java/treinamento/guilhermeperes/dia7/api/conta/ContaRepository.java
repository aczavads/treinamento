package treinamento.guilhermeperes.dia7.api.conta;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;

import treinamento.guilhermeperes.dia7.base.BaseRepository;

public interface ContaRepository extends BaseRepository<Conta> {
	
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
	
	@Query("SELECT c from Conta c")
	public Slice<Conta> findAll(Pageable pageable);
}
