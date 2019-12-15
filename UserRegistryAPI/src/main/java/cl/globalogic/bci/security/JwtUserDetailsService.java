package cl.globalogic.bci.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.globalogic.bci.entities.User;
import cl.globalogic.bci.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String _userName) throws UsernameNotFoundException {
		
		User user=userRepository.findAllByUsername(_userName);

		if (user == null) {


			throw new UsernameNotFoundException("User not found with userName: " + _userName);
		}
	
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	
	}
	
	
	
}
