package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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

public interface ContaContabilRepository extends JpaRepository<ContaContabilFS2, UUID> {

	@Query(nativeQuery = true, value = "select count(*) from conta_contabilfs2")
	Long contarContas();

	@Query(nativeQuery = true, value = "select count(*) from conta_contabilfs2")
	Page<ContaContabilFS2> recuperarTodasPaginado(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabilfs2")
	Slice<ContaContabilFS2> recuperarTodasPaginadoComSlice(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabilfs2 limit :size offset (:page * :size)")
	List<ContaContabilFS2> recuperarTodasPaginadoManualmente(int page, int size);
//	List<ContaContabilFS2> recuperarTodasPaginadoManualmente(@Param(value = "page") int page, @Param(value = "size") int size);

	@Query(nativeQuery = true, value = "select * from conta_contabilfs2 c where c.conta_superior_id is null")
	List<ContaContabilFS2> selecionarContasRaiz();

	// Para retornar a query com o novo campo "nivel" precisamos retornar
	// com um tipo de retorno que aceite qualquer conjunto de campos e valores.
	// Podemos criar um DTO específico ou usar uma lista de mapas. Ex:
	// List<Map<String, Object>> recuperarHierarquia();
	@Query(nativeQuery = true, value = "WITH RECURSIVE hierarquia (id, nome, codigo, conta_superior_id, nivel) AS (\r\n"
			+ "SELECT id, nome, codigo, conta_superior_id, 1 \r\n" + "  FROM conta_contabil \r\n"
			+ " WHERE conta_superior_id is null\r\n" + "UNION ALL\r\n"
			+ "SELECT f.id, f.nome, f.codigo, f.conta_superior_id, hierarquia.nivel+1 \r\n"
			+ "  FROM conta_contabil f, hierarquia \r\n" + " WHERE f.conta_superior_id = hierarquia.id\r\n" + ") "
			+ "SELECT cast(id as varchar) as \"id\", nome, cast(conta_superior_id as varchar) as conta_superior_id, codigo, nivel FROM hierarquia")
	List<Map<String, Object>> recuperarHierarquia();
}
