package com.codefair.solobob;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserInfoTO registerUser(RegisterUserTO registerUserTO) {
        User user = User.builder()
                .email(registerUserTO.getEmail())
                .password(registerUserTO.getPassword())
                .name(registerUserTO.getName()).build();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return new UserInfoTO(user.getId(), user.getName());
    }

    public UserInfoTO login(LoginTO loginTO) {
        UserInfoTO userInfoTO = null;
        User user = userRepository.findByEmail(loginTO.getEmail());
        if (user != null && bCryptPasswordEncoder.matches(loginTO.getPassword(), user.getPassword())) {
            userInfoTO = new UserInfoTO(user.getId(), user.getName());
        }
        return userInfoTO;
    }
}
