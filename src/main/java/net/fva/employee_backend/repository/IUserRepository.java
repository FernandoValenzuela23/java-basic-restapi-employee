package net.fva.employee_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fva.employee_backend.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	
	// Based in findBy keyword
	User findByUsername(String username);
	
	// Based in findBy keyword
	boolean existsByUsername(String username);

}
