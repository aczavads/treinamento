package treinamento.thyagofranco.dia7.plano_de_contas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import treinamento.thyagofranco.dia7.plano_de_contas.entity.PlanoDeContasT;

public interface PlanodeContasTRepository extends JpaRepository<PlanoDeContasT, UUID>{

}
