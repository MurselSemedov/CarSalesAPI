package com.mursalsamad.controller.impl;

import com.mursalsamad.controller.IAuthController;
import com.mursalsamad.model.response.UserOutputDTO;
import com.mursalsamad.jwt.AuthRequest;
import com.mursalsamad.jwt.AuthResponse;
import com.mursalsamad.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class AuthController implements IAuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public UserOutputDTO register(@RequestBody AuthRequest request) {
        return authService.register(request);
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }
}
