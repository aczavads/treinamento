package valdenir.junior.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContaContabilsRepository extends JpaRepository<ContaContabils, UUID> {

	@Query(nativeQuery = true, value = "select count(*) from conta_contabils")
	Long contarContas();

	@Query(nativeQuery = true, value = "select * from conta_contabils where conta_superior_id is null")
	List<ContaContabils> selecionarContasRaiz();

	@Query(nativeQuery = true, value = "WITH hierarquia(id , nome, conta_superior_id, nivel) AS ( "
			+ "SELECT id, nome, conta_superior_id, 1 FROM conta_contabils WHERE conta_superior_id IS NULL "
			+ "UNION ALL "
			+ "SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel+1 FROM conta_contabils f, hierarquia where f.conta_superior_id = hierarquia.id "
			+ ") select * from hierarquia ")
	List<Map<String, Object>> recuperarHierarquia();

	@Query(nativeQuery = true, value = "select * from conta_contabils", countQuery = "select count(*) from conta_contabils")
	Page<ContaContabils> recuperarTodas(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabils")
	Slice<ContaContabils> recuperarTodasFatiadas(Pageable pageable);

	@Query(nativeQuery = true, value = "select * from conta_contabils limit :size offset (:page * :size)")
	List<ContaContabils> recuperarTodasPaginadoManualmente(@Param("page") int page, @Param("size") int size);

	@Query(nativeQuery = true, value = "select cc.* from conta_contabils cc inner join conta_plano_de_contass cpc on cc.id = cpc.conta_contabils_id where cpc.plano_de_contas_id = :id")
	List<ContaContabils> findContasDoPlanoDeContas(UUID id);
}
