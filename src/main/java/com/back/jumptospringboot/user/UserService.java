package com.back.jumptospringboot.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public SiteUser create(String userName, String password, String email){

        SiteUser user = new SiteUser();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);


        return this.userRepository.save(user);

    }


}
