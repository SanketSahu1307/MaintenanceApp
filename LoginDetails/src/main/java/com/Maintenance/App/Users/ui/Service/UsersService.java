package com.Maintenance.App.Users.ui.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maintenance.App.Users.ui.Exception.UsersNotFoundException;
import com.Maintenance.App.Users.ui.Model.Users;
import com.Maintenance.App.Users.ui.Repository.UsersRepository;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;

	public Users SaveUsers(Users users) {
		return usersRepo.save(users);
	}

	public List<Users> getUsersData() {
		return usersRepo.findAll();
	}
	
	public Optional<Users> getByUsersId(Long id) {
		Optional<Users> users=usersRepo.findById(id);
		if (!users.isPresent()) {
			throw new UsersNotFoundException("Users Not Found with Id "+id);
		}
		else {
			return users;
		}
	}

	public void deleteByUsersId(Long id) {
		Optional<Users> users=usersRepo.findById(id);
		if (!users.isPresent()) {
			throw new UsersNotFoundException("Users Not Found with Id "+id);
		}
		else {
			usersRepo.deleteById(id);
		}
	}

	public Users updateByUsersId(Users users) {
		return usersRepo.save(users);
	}


}
