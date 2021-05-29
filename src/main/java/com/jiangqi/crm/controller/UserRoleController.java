package com.jiangqi.crm.controller;

import com.jiangqi.crm.base.BaseController;
import com.jiangqi.crm.service.UserRoleService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**

 */
@Controller
public class UserRoleController extends BaseController {

    @Resource
    private UserRoleService userRoleService;
}
