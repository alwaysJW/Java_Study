package com.cs.service;

import com.cs.domain.Login;

public interface LoginService {
    Login login(Login login);

    void register(Login login);

    Login forget(Login login);

    void findPass(Login login);
}
