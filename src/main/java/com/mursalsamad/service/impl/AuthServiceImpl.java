package com.mursalsamad.service.impl;

import com.mursalsamad.dto.output.UserOutputDTO;
import com.mursalsamad.jwt.AuthRequest;
import com.mursalsamad.jwt.AuthResponse;
import com.mursalsamad.jwt.JwtService;
import com.mursalsamad.model.User;
import com.mursalsamad.repository.UserRepository;
import com.mursalsamad.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    public UserOutputDTO register(AuthRequest request) {
        User user = new User();
        UserOutputDTO outputDTO = new UserOutputDTO();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        BeanUtils.copyProperties(user,outputDTO);
        return outputDTO;
    }

    public AuthResponse authenticate(AuthRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
        try{
            authenticationProvider.authenticate(authenticationToken);
            Optional<User> optional = userRepository.findByUsername(request.getUsername());
            return optional.map(user -> new AuthResponse(jwtService.generateToken(user))).orElseThrow(Exception::new);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
