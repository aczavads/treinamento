package diegomucheniski.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import diegomucheniski.domains.PlanoDeContas;

public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContas, UUID> {

}
