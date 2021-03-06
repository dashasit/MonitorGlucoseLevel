package com.codetheory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codetheory.model.User;
import com.codetheory.model.UserGlucoseHistory;
import com.codetheory.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);

			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/user/glucoseHistory/select")
	public ResponseEntity<List<UserGlucoseHistory>> getUserGlucoseHistory(int userId, String reportType) {
		List<UserGlucoseHistory> histories = null;
		try {
			histories = userService.getUserGlucoseHistory(userId, reportType);
			
			return new ResponseEntity<List<UserGlucoseHistory>>(histories, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<UserGlucoseHistory>>(histories, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/user/glucoseHistory/add")
	public ResponseEntity<UserGlucoseHistory> addUserGlucoseHistory(
			@RequestBody UserGlucoseHistory history) {
		try {
			userService.addUserGlucoseHistory(history);

			return new ResponseEntity<UserGlucoseHistory>(history,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserGlucoseHistory>(
				HttpStatus.TOO_MANY_REQUESTS);
	}

}
