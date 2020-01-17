package diegomucheniski.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // Para não tentar instanciar quando subir o contexto do Spring
public interface BaseRepository<ENTITY> extends JpaRepository<ENTITY, Long> {
		
}
