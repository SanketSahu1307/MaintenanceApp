package com.Maintenance.App.Users.ui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maintenance.App.Users.ui.Model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
