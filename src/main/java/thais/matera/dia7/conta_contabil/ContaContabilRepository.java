package thais.matera.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
 * query recursiva: contando de 1 até 10
 */
//WITH contador (numero) AS (
//SELECT 1 AS numero
//UNION ALL
//SELECT contador.numero+1 FROM contador WHERE contador.numero < 10
//)
//SELECT * FROM contador

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {
	@Query(nativeQuery = true, value = "select count(*) from conta_contabil")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabil c where c.conta_superior_id is null")
	List<ContaContabil> selecionarContasRaiz();
	
	@Query(nativeQuery = true, value = 
			"WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) as ( " + 
				"SELECT id, nome, conta_superior_id, 1 " + 
				"FROM conta_contabil " +
				"WHERE conta_superior_id is null " + 
			"UNION ALL " + 
				"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 " +
				"FROM conta_contabil f, hierarquia " + 
				"WHERE f.conta_superior_id = hierarquia.id " + 
			")" + 
			"SELECT * FROM hierarquia")
	List<Map<String, Object>> recuperarHierarquia();
}
