package com.acme.usermanagement.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.usermanagement.domain.Email;
import com.acme.usermanagement.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByCredentialEmail(Email email);

}