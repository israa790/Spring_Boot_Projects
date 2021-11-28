package com.isra.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.isra.users.entities.Role;
import com.isra.users.entities.User;
import com.isra.users.repos.RoleRepository;
import com.isra.users.repos.UserRepository;

@Transactional // toutes les méthodes de la classe seront automatiquement enregistrer lorsque je modifier les objets
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;

	@Autowired
	RoleRepository roleRep;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r); // pour récupérer les roles de user sous forme d'une liste
		return usr;
	}

	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userRep.findAll();
	}
}
