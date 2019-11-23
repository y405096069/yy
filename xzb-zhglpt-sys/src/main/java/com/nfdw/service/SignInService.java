package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.SignIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignInService extends BaseService<SignIn,String> {

    List<SignIn> getAll(@Param("no") String no, @Param("num") String num);

    List<SignIn> showMenuJsonList();

    Integer updateById(SignIn signIn);
}
