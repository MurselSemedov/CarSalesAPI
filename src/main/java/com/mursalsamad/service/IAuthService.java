package com.mursalsamad.service;

import com.mursalsamad.model.response.UserOutputDTO;
import com.mursalsamad.jwt.AuthRequest;
import com.mursalsamad.jwt.AuthResponse;

public interface IAuthService {

    public UserOutputDTO register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
