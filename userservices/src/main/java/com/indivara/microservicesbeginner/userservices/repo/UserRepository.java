package com.indivara.microservicesbeginner.userservices.repo;


import com.indivara.microservicesbeginner.userservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
