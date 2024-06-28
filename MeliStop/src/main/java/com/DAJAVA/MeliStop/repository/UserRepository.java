package com.DAJAVA.MeliStop.repository;

import com.DAJAVA.MeliStop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

