package com.jiangqi.crm.service;

import com.jiangqi.crm.base.BaseService;
import com.jiangqi.crm.dao.UserRoleMapper;
import com.jiangqi.crm.vo.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 江七
 */
@Service
public class UserRoleService extends BaseService<UserRole, Integer> {

    @Resource
    private UserRoleMapper userRoleMapper;
}
