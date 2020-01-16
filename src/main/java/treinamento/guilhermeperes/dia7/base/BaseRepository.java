package treinamento.guilhermeperes.dia7.base;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity> extends JpaRepository<ENTITY, UUID> {
}
