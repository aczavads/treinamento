package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MyContaContabilRepository extends JpaRepository<MyContaContabil, UUID> {

//	WITH contador(numero) as (
//			 select 1 as numero
//			union all
//			select contador.numero+1 from contador where contador.numero < 10
//			)
//			select * from contador;
	
//	WITH contador(numero, id) as (
//			 select 1 as numero, random_uuid()
//			union all
//			select contador.numero+1, random_uuid() from contador where contador.numero < 10
//			)
//			select * from contador;
	
	@Query(nativeQuery = true, value = "select count(*) from my_conta_contabil")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from my_conta_contabil c where c.conta_superior_id is null")
	List<MyContaContabil> selecionarContasRaiz();
	
	@Query(nativeQuery = true, 
			value = "WITH RECURSIVE hierarquia(id, nome, conta_superior_id, nivel) as ( " + 
			"SELECT cast(id as uuid), nome, cast(conta_superior_id as uuid), 1 " + 
			"   FROM my_conta_contabil where conta_superior_id is NULL " + 
			"UNION ALL " + 
			"SELECT cast(f.id as uuid), f.nome, cast(f.conta_superior_id as uuid), hierarquia.nivel+1" + 
			"   FROM my_conta_contabil f, hierarquia" + 
			"   WHERE f.conta_superior_id = hierarquia.id " + 
			")" + 
			" select * from hierarquia")
	List<Map<String, Object>> selecionarContasPorHierarquia();
	
	List<MyContaContabil> findByCodigo(String codigo);
	
	@Query(nativeQuery = true, value = "select * from my_conta_contabil", countQuery = "select count(*) from my_conta_contabil")
	Page<MyContaContabil> recuperarTodas(Pageable pageable);
	
	@Query(nativeQuery = true, value = "select * from my_conta_contabil")
	Slice<MyContaContabil> recuperarTodasFateadas(Pageable pageable);

	@Query(nativeQuery = true , value = "select * from my_conta_contabil limit :size offset (:page * :size)")
	List<MyContaContabil> recuperarTodasManual(int page, int size);
	
	@Query(nativeQuery = true ,
			value = "select cc.* "
					+ "from MY_CONTA_CONTABIL cc "
					+ "inner join MY_CONTA_PLANO_DE_CONTAS cpc on cc.id = cpc.MY_CONTA_CONTABIL_ID "
					+ "where cpc.MY_PLANO_DE_CONTAS_ID = :idPlanoDeContas")
	Set<MyContaContabil> recuperarTodasContasVinculadasAoPlanoDeContas(UUID idPlanoDeContas);
	
}
