package com.Maintenance.App.Users.ui.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Maintenance.App.Users.ui.Model.Users;
import com.Maintenance.App.Users.ui.Service.UsersService;


@RestController
@RequestMapping(path = "/users")
public class UsersController {
	
	@Autowired
	private UsersService usersServ;
	
	@PostMapping(path = "/create",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Users> createUsersModal(@Valid @RequestBody Users users) {
		return new ResponseEntity<Users>(usersServ.SaveUsers(users),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/read",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Users>> getUsers() {
		return new ResponseEntity<List<Users>>(usersServ.getUsersData(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/read/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Optional<Users>> getUsersById(@PathVariable("id") Long id) {
		return new ResponseEntity<Optional<Users>>(usersServ.getByUsersId(id),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> deleteUsersById(@PathVariable("id")Long id) {
		usersServ.deleteByUsersId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Users> updateUsersById(@Valid @RequestBody Users users) {
		return new ResponseEntity<Users>(usersServ.updateByUsersId(users),HttpStatus.ACCEPTED);
	}
	

}
