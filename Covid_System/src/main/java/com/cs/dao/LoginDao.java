package com.cs.dao;

import com.cs.domain.Login;

public interface LoginDao {
    Login login(Login login);

    void register(Login login);

    Login forget(Login login);

    void findPass(Login login);
}
