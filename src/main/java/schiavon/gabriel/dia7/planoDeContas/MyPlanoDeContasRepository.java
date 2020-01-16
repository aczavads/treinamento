package schiavon.gabriel.dia7.planoDeContas;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPlanoDeContasRepository extends JpaRepository<MyPlanoDeContas, UUID>{

}
