package cl.globalogic.bci.test;

import org.junit.jupiter.api.TestMethodOrder;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.globalogic.bci.controller.UserController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerTest {
	
	@Autowired
	UserController api;


	@Test
    @Order(1)    
    public void testRegisterUser() {
        assertEquals(HttpStatus.CREATED, api.createUser(UserFixture.validUser()).getStatusCode());
    }
     
    @Test
    @Order(2)    
    public void testRegisterAnExistentEmail() {
		 assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, api.createUser(UserFixture.validUser()).getStatusCode());
    }
  
    @Test
    @Order(3)    
    public void testRegisterAnRepeatedUser() {
    	assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, api.createUser(UserFixture.validRepeatedUser()).getStatusCode());
    }

 
 
 
 
}
