package cl.globalogic.bci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.globalogic.bci.entities.Phone;
import cl.globalogic.bci.entities.User;
import cl.globalogic.bci.repository.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	PhoneRepository phoneRepository;
	
	public List <Phone> getPhonesByUser(User _user) {
		List <Phone> phones = phoneRepository.findAllByUser(_user);
		return phones;
	}
	
	public Phone save(Phone _phone) {
		return phoneRepository.save(_phone);
	}
}
