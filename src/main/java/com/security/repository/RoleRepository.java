package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.models.ERole;
import com.security.models.Authority;

@Repository
public interface RoleRepository extends JpaRepository<Authority, Long> {
	Optional<Authority> findByAuthority(ERole name);
}
