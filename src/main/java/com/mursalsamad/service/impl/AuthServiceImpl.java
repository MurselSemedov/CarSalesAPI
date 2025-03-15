package com.mursalsamad.service.impl;

import com.mursalsamad.model.response.UserOutputDTO;
import com.mursalsamad.jwt.AuthRequest;
import com.mursalsamad.jwt.AuthResponse;
import com.mursalsamad.jwt.JwtService;
import com.mursalsamad.dao.entity.UserEntity;
import com.mursalsamad.dao.repository.UserRepository;
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
        UserEntity userEntity = new UserEntity();
        UserOutputDTO outputDTO = new UserOutputDTO();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity,outputDTO);
        return outputDTO;
    }

    public AuthResponse authenticate(AuthRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
        try{
            authenticationProvider.authenticate(authenticationToken);
            Optional<UserEntity> optional = userRepository.findByUsername(request.getUsername());
            return optional.map(userEntity -> new AuthResponse(jwtService.generateToken(userEntity))).orElseThrow(Exception::new);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
