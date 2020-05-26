package it.neo7bf.springbootconjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.neo7bf.springbootconjpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByLastName(String lastName);

    User findById(long id);
	
}
