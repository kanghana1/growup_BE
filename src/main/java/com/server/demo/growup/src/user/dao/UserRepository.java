package com.server.demo.growup.src.user.dao;

import com.server.demo.growup.src.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserUuid(String userUuid);
    Optional<User> findById(Long id);
}
