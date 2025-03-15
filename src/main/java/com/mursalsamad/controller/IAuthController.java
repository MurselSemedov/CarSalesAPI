package com.mursalsamad.controller;

import com.mursalsamad.model.response.UserOutputDTO;
import com.mursalsamad.jwt.AuthRequest;
import com.mursalsamad.jwt.AuthResponse;

public interface IAuthController {

    public UserOutputDTO register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
