package miu.edu.demo.service;

import miu.edu.demo.dto.request.LoginRequest;
import miu.edu.demo.dto.request.RefreshTokenRequest;
import miu.edu.demo.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
