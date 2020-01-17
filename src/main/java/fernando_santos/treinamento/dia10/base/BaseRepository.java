package fernando_santos.treinamento.dia10.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ENTITY> extends JpaRepository<ENTITY, Long> {
	
	Page<ENTITY> findAll(Pageable pageable);

}
