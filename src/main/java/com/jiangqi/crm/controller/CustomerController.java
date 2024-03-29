package com.jiangqi.crm.controller;

import com.jiangqi.crm.base.BaseController;
import com.jiangqi.crm.base.ResultInfo;
import com.jiangqi.crm.query.CustomerQuery;
import com.jiangqi.crm.service.CustomerService;
import com.jiangqi.crm.vo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**

 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    /**
     * 分页条件查询客户列表
     *
     *

     * @param customerQuery
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCustomerByParams(CustomerQuery customerQuery) {
        return customerService.queryCustomerByParams(customerQuery);
    }

    /***
     * 进入客户信息管理页面
     *
     *

     * @param
     * @return java.lang.String
     */
    @RequestMapping("index")
    public String index() {
        return "customer/customer";
    }


    /**
     * 添加客户信息
     *
     *

     * @param customer
     * @return com.jiangqi.crm.base.ResultInfo
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addCustomer(Customer customer) {
        customerService.addCustomer(customer);
        return success("添加客户信息成功！");
    }


    /**
     * 修改客户信息
     *
     *

     * @param customer
     * @return com.jiangqi.crm.base.ResultInfo
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return success("修改客户信息成功！");
    }


    /**
     * 删除客户信息
     *
     *

     * @param id
     * @return com.jiangqi.crm.base.ResultInfo
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
        return success("删除客户信息成功！");
    }


    /**
     * 打开添加或修改客户信息的对话框
     *
     *

     * @param
     * @return java.lang.String
     */
    @RequestMapping("toAddOrUpdateCustomerPage")
    public String toAddOrUpdateCustomerPage(Integer id, HttpServletRequest request) {
        // 如果id不为空，则查询客户记录
        if (null != id) {
            // 通过id查询客户记录
            Customer customer = customerService.selectByPrimaryKey(id);
            // 将客户记录存到作用域中
            request.setAttribute("customer",customer);
        }
        return "customer/add_update";
    }

    /**
     * 打开客户的订单页面
     *
     *

     * @param
     * @return java.lang.String
     */
    @RequestMapping("toCustomerOrderPage")
    public String toCustomerOrderPage(Integer customerId, Model model) {
        // 通过客户ID查询客户记录，设置到请求域中
        model.addAttribute("customer", customerService.selectByPrimaryKey(customerId));
        return "customer/customer_order";
    }


    /**
     * 客户贡献分析
     *
     *

     * @param customerQuery
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("queryCustomerContributionByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerContributionByParams(CustomerQuery customerQuery) {
        return customerService.queryCustomerContributionByParams(customerQuery);
    }


    /**
     * 查询客户构成 （折线图）
     *
     *

     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("countCustomerMake")
    @ResponseBody
    public Map<String, Object> countCustomerMake() {
        return customerService.countCustomerMake();
    }


    /**
     * 查询客户构成 （饼状图）
     *
     *

     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("countCustomerMake02")
    @ResponseBody
    public Map<String, Object> countCustomerMake02() {
        return customerService.countCustomerMake02();
    }

}
