package cl.globalogic.bci.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.globalogic.bci.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,String>{

	public int countByEmail(String email);
	public User findAllByUsername(String userName);
	public int countByUsername(String userName);
	public User findAllById(String id);

	
	
	
}


