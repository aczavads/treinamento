package schiavon.gabriel.dia7.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ID, ENTIDADE> extends JpaRepository<ENTIDADE, ID> {

}
