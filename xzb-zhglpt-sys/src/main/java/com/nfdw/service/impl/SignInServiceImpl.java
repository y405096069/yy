package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.ApplicationAnnoun;
import com.nfdw.entity.SignIn;
import com.nfdw.mapper.SignInMapper;
import com.nfdw.service.SignInService;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignInServiceImpl  extends BaseServiceImpl<SignIn,String> implements SignInService{

    @Autowired
    SignInMapper signInMapper;

    @Override
    public List<SignIn> getAll(String no, String num) {
        return signInMapper.getAll(no,num);
    }

    @Override
    public List<SignIn> showMenuJsonList() {
        return null;
    }

    @Override
    public Integer updateById(SignIn signIn) {

        return signInMapper.updateById(signIn);
    }

    @Override
    public BaseMapper<SignIn, String> getMappser() {

        return signInMapper;
    }
}
