package com.security.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.models.Authority;
import com.security.models.User;
import com.security.repository.RoleRepository;
import com.security.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository rolesRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		Authority auth = rolesRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Authority Not Found with username: " + username));

		return UserDetailsImpl.build(user, auth);
	}

}
