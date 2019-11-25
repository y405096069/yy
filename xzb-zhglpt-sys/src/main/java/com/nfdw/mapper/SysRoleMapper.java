package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.CurrentRole;
import com.nfdw.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole,String> {
    SysRole findByUser(String getId);

    List<CurrentRole> getUserRoles(@Param("userId") String userId);

}