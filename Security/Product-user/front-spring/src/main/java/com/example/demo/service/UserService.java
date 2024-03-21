package com.example.demo.service;


import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean verifyUser(String mail, String password){
        return userRepository.findByMail(mail)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(()-> new UsernameNotFoundException("User not found with mail : " + mail));
    }

    public String generateToken(String mail, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return token;
    }


    public boolean checkUserNameExists(String mail) {
        return userRepository.findByMail(mail).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return userRepository.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + mail));
    }
}
