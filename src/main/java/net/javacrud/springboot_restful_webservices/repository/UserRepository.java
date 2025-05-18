package net.javacrud.springboot_restful_webservices.repository;

import net.javacrud.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//crud method to perform curd database operation for User Jpa entiry
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
