package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.ApplicationAnnoun;
import com.nfdw.entity.SignIn;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SignInMapper extends BaseMapper<SignIn,String> {

    List<SignIn> getAll(@Param("no") String no, @Param("num") String num);
    Integer updateById(SignIn signIn);




}
