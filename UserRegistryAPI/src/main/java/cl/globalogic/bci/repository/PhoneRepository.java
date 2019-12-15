package cl.globalogic.bci.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.globalogic.bci.entities.Phone;
import cl.globalogic.bci.entities.User;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,UUID>{

	public List <Phone> findAllByUser(User userId);
}
