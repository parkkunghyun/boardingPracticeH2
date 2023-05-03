package com.boardingH2.boardingPracticeH2.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password)
    {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
        // spring 시큐리티에서 제공하는 클래스! ->  비밀번호를 암호화!
        // BCryptPasswordEncoder는 BCrypt해싱함수를 사용해서 비밀번호를 암호화
        // 이때 new로 객체를 직접 생성보다는 PasswordEncoder라는 걸 Bean으로 등록해서 사용하기!
        // 통합해서 수정하기 편함!
    }
}
