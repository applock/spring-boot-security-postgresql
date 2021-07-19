package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.models.Authority;
import com.security.models.ERole;

@Repository
public interface RoleRepository extends JpaRepository<Authority, Long> {
	Optional<Authority> findByAuthority(ERole authority);

	Optional<Authority> findByUsername(String username);
}
