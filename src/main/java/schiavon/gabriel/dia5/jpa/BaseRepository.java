package schiavon.gabriel.dia5.jpa;

import java.util.List;
import java.util.UUID;

public interface BaseRepository<T> {

	public void insert(T data);
	public void update(T data);
	public void delete(T data);
	public void delete(UUID id);
	public List<T> selectAll();
	
}