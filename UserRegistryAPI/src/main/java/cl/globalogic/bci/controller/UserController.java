package cl.globalogic.bci.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.globalogic.bci.beans.ErrorMessage;
import cl.globalogic.bci.entities.Phone;
import cl.globalogic.bci.entities.User;
import cl.globalogic.bci.service.PhoneService;
import cl.globalogic.bci.service.UserService;
import cl.globalogic.bci.util.Constants;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PhoneService phoneService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/user/register")
	public ResponseEntity createUser(@Valid @RequestBody User _user) {
		ResponseEntity rsEntity;
		try {
			if (userService.validateExistUser(_user.getEmail())) {

				if (userService.validateUserName(_user.getUsername())) {
					User user = userService.save(_user);
					rsEntity = new ResponseEntity(user, HttpStatus.CREATED);
				} else {
					ErrorMessage error = new ErrorMessage();
					error.setMensaje(Constants.ERROR_02.value());
					rsEntity = new ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY);
				}
			} else {

				ErrorMessage error = new ErrorMessage();
				error.setMensaje(Constants.ERROR_01.value());
				rsEntity = new ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY);

			}
		} catch (Exception e) {
			e.printStackTrace();

			ErrorMessage error = new ErrorMessage();
			error.setMensaje(Constants.ERROR_GENERIC.value());
			rsEntity = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return rsEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/user")
	public ResponseEntity getUser(@Valid @RequestParam String id) {
		ResponseEntity rsEntity;
		try {

			User user = userService.getUser(id);
			if(null==user) {
				rsEntity = new ResponseEntity(user, HttpStatus.NOT_FOUND);

			}
			else {
				rsEntity = new ResponseEntity(user, HttpStatus.OK);

			}
		} catch (Exception e) {
			e.printStackTrace();

			ErrorMessage error = new ErrorMessage();
			error.setMensaje(Constants.ERROR_GENERIC.value());
			rsEntity = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return rsEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/phone")
	public ResponseEntity getPhonesByUser(@Valid @RequestParam String id) {
		ResponseEntity rsEntity;
		try {
			
			User user = userService.getUser(id);
			if(null==user) {
				rsEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

			}else {
				List<Phone> phones = phoneService.getPhonesByUser(user);
				if(phones.size()==0) {
					rsEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

				}
				else {
					rsEntity = new ResponseEntity(phones, HttpStatus.OK);

				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();

			ErrorMessage error = new ErrorMessage();
			error.setMensaje(Constants.ERROR_GENERIC.value());
			rsEntity = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return rsEntity;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String errorMessage = error.getDefaultMessage();
			errors.put("mensaje", errorMessage);
		});
		return errors;
	}

}
