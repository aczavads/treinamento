package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {

	@Query(nativeQuery = true, value = "select count(*) from conta_contabil")
	Long contarContas();

	@Query(nativeQuery = true, value = "select * from conta_contabil c where c.conta_superior_id is null")
	List<ContaContabil> selecionarContasRaiz();

	@Query(nativeQuery = true, value = "select * from conta_contabil", countQuery = "select count(*) from conta_contabil")
	Page<ContaContabil> recuperarTodas(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabil")
	Slice<ContaContabil> recuperarTodasFatiadas(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabil limit :size offset (:page * :size) ")
	List<ContaContabil> recuperarTodasManualmente(int page, int size);

	@Query(nativeQuery = true, value = "WITH RECURSIVE hierarquia (id, nome, conta_superior_id, nivel) AS (\r\n"
			+ "SELECT id, nome, conta_superior_id, 1 \r\n" + "   FROM conta_contabil \r\n"
			+ "   WHERE conta_superior_id is null\r\n" + "UNION ALL\r\n"
			+ "SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel + 1 \r\n"
			+ "   FROM conta_contabil f, hierarquia \r\n" + "   WHERE f.conta_superior_id = hierarquia.id)\r\n" + "\r\n"
			+ "SELECT * FROM hierarquia")
	List<Map<String, Object>> selecionarContasPelaHierarquia();

	@Query(nativeQuery = true, value = "select cc.* from " + "conta_contabil cc "
			+ "inner join conta_plano_de_contas cpc on cc.id = cpc.conta_contabil_id "
			+ "where cpc.plano_de_contas_id = :idPlanoDeContas")
	List<ContaContabil> recuperarContasDoPlanoDeContas(UUID idPlanoDeContas);
}
