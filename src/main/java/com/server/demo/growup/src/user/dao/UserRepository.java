package com.server.demo.growup.src.user.dao;

import com.server.demo.growup.src.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
