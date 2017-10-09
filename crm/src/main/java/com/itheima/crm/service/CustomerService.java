package com.itheima.crm.service;

import java.util.List;

import javax.jws.WebService;


import com.itheima.crm.domain.Customer;

/**  
 * ClassName:CustomerService <br/>  
 * Function:  <br/>  
 * Date:     2017年9月22日 下午3:32:20 <br/>       
 */
@WebService
public interface CustomerService {

    List<Customer> findAll();
    //获取未关联的客户
    List<Customer> findCustomersNotAssociated();
    //获取以关联的客户
    List<Customer> findCustomersAssociatedToFixedArea(String fixedAreaId);
    //关联客户到指定的定区
    void assignCustomers2FixedArea(String fixedAreaId,Integer[] ids);
    //注册账号
    void regist (Customer customer);
    //通过手机号找用户
    Customer findByTelephone(String telephone);
    //激活
    void activedCustomer(String telephone);
    //登陆
    Customer login(String telephone,String password);
    //查询定区id
    String findAddressByFixedAreaId(String address);
}
  
