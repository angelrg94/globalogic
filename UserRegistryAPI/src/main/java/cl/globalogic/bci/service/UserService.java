package cl.globalogic.bci.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.globalogic.bci.entities.Phone;
import cl.globalogic.bci.entities.User;
import cl.globalogic.bci.repository.UserRepository;
import cl.globalogic.bci.security.JwtTokenUtil;
import cl.globalogic.bci.security.JwtUserDetailsService;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private PhoneService phoneService;
	public User getUser(String _id) {
		return userRepository.findAllById(_id);
	}
	

	/**
	 * @author agonzalez
	 * Metodo encargado de insertar el usuario, genear token JWT y cifrar clave
	 * **/
	public User save(User _user) {
		
		
		User user =  new User();
		List<Phone> phones = new ArrayList<Phone>();
		user.setEmail(_user.getEmail());
		user.setPassword(_user.getPassword());
		user.setUsername(_user.getUsername());
		user.setLastLogin(new Date());
		user.setModified(new Date());
		user.setCreationDate(new Date());
		userRepository.save(user);
		Phone phone;
		
		for(Phone bean :_user.getPhones()) {
			phone = new Phone();
			phone.setCityCode(bean.getCityCode());
			phone.setCountryCode(bean.getCountryCode());
			phone.setNumber(bean.getNumber());
			phone.setUser(user);
			phones.add(phone);
			phoneService.save(phone);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		user.setPassword(bcryptEncoder.encode(_user.getPassword()));
		user.setToken(token);
		user.setActive(true);
	    userRepository.save(user);

		
		return user;	
	}

	/**
	 * @author agonzalez
	 * Metodo para validar si el correo enviado existe en la BD
	 * **/
	public boolean validateExistUser(String email) {
		
		int counter =userRepository.countByEmail(email);
	
		return 	counter<=0?true:false;
		
	}
	
	/**
	 * @author agonzalez
	 * Metodo para validar si el username enviado existe en la BD no se utiliza por estar fuera del requerimiento pero se recomienda realizar dicha validacion
	 * 
	 * **/
	public boolean validateUserName(String userName) {
		
		
		int counter=userRepository.countByUsername(userName);
		
		return counter<=0?true:false;
	}
	

}
