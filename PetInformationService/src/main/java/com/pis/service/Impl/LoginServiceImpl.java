package com.pis.service.Impl;

import com.pis.dao.Impl.LoginDaoImpl;
import com.pis.dao.LoginDao;
import com.pis.domain.Login;
import com.pis.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private final LoginDao dao=new LoginDaoImpl();
    @Override
    public Login login(Login login) {
        return dao.login(login);
    }

    @Override
    public void register(Login login) {
        dao.register(login);
    }

    @Override
    public Login forget(Login login) {

        return dao.forget(login);
    }

    @Override
    public void findPass(Login login) {
        dao.findPass(login);
    }
}
