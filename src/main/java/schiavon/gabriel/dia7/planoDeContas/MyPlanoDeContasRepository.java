package schiavon.gabriel.dia7.planoDeContas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPlanoDeContasRepository extends JpaRepository<MyPlanoDeContas, Long>{

}
