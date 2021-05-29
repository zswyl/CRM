package com.jiangqi.crm.service;

import com.jiangqi.crm.vo.Permission;
import com.jiangqi.crm.base.BaseService;
import com.jiangqi.crm.dao.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**

 */
@Service
public class PermissionService extends BaseService<Permission,Integer> {

    @Resource
    private PermissionMapper permissionMapper;


    /***
     * 通过查询用户拥有的角色，角色拥有的资源，得到用户拥有的资源列表 （资源权限码）
     *
     *

     * @param userId
     * @return java.util.List<java.lang.String>
     */
    public List<String> queryUserHasRoleHasPermissionByUserId(Integer userId) {
        return permissionMapper.queryUserHasRoleHasPermissionByUserId(userId);
    }
}
