package com.server.demo.growup.src.user.service;

import com.server.demo.growup.global.exception.BaseException;
import com.server.demo.growup.global.response.BaseStatus;
import com.server.demo.growup.src.user.dao.UserRepository;
import com.server.demo.growup.src.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User getUserByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(BaseStatus.NOT_FOUND_USER));

        return user;
    }

    public User getUserByUserUuid(String userUuid) {
        User user = userRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(BaseStatus.NOT_FOUND_USER));

        return user;
    }
}
