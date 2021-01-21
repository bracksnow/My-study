package simpleblog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import simpleblog.blog.domain.Role;
import simpleblog.blog.domain.User;
import simpleblog.blog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRole(Role.USER);//기본적으로는 사용자로 저장하기
        return userRepository.save(user);
    }
}
