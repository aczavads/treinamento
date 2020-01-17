package treinamento.dia10.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRespository<ENTITY> extends JpaRepository<ENTITY, Long> {

		
}
