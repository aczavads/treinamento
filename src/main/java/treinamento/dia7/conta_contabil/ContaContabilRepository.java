package treinamento.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
--query recursiva de exemplo: contando de 1 até 10
WITH contador (numero) AS (
SELECT 1 AS numero
UNION ALL
SELECT contador.numero+1 FROM contador WHERE contador.numero < 10
)
SELECT * FROM contador

--query recursiva para gerar uma tabela com N registros aleatórios com UUID
create table teste as 
WITH contador (numero, id) AS (
SELECT 1 AS numero, random_uuid()
UNION ALL
SELECT contador.numero+1, random_uuid() FROM contador WHERE contador.numero < 100000
)
SELECT * FROM contador
 */

public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID>{
	
	@Query(nativeQuery = true, value = "select count(*) from conta_contabil")
	Long contarContas();
	
	
	@Query(nativeQuery = true, value = "select * from conta_contabil c where c.conta_superior_id is null")
	List<ContaContabil> selecionarContasRaiz();
	
	//Para retornar a query com o novo campo "nivel" precisamos retornar 
	//com um tipo de retorno que aceite qualquer conjunto de campos e valores.
	//Podemos criar um DTO específico ou usar uma lista de mapas. Ex:
	//List<Map<String, Object>> recuperarHierarquia();
	@Query(nativeQuery = true, 
			value="WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) AS (\r\n" + 
					"SELECT id, nome, conta_superior_id, 1 \r\n" + 
					"  FROM conta_contabil \r\n" + 
					" WHERE conta_superior_id is null\r\n" + 
					"UNION ALL\r\n" + 
					"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 \r\n" + 
					"  FROM conta_contabil f, hierarquia \r\n" + 
					" WHERE f.conta_superior_id = hierarquia.id\r\n" + 
					")\r\n" + 
					"SELECT * FROM hierarquia")
	List<Map<String, Object>> recuperarHierarquia();
	

}








