package cl.globalogic.bci.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.globalogic.bci.entities.User;
import cl.globalogic.bci.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	
	  @Test
	  void savedUserIsNotNull() {
	    
	    User savedUser = userService.save(UserFixture.validUser());
	    
	    assertNotNull(savedUser);
	 
	  }
}
