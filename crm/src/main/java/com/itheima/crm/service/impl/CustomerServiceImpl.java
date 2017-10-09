package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;

/**  
 * ClassName:CustomerServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     2017年9月22日 下午3:35:22 <br/>       
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    public List<Customer> findAll() {

        return dao.findAll();
    }

    @Override
    public List<Customer> findCustomersNotAssociated() {
          
        return dao.findByFixedAreaIdIsNull();
    }

    @Override
    public List<Customer> findCustomersAssociatedToFixedArea(String fixedAreaId) {
          
        return dao.findCustomersAssociatedToFixedArea(fixedAreaId);
    }

    @Override
    public void assignCustomers2FixedArea(String fixedAreaId, Integer[] ids) {
        //要把和定区相关的客户清空定区的ID
        dao.updateFixedAreanull(fixedAreaId);
        //把客户和定区关联
        if(ids != null && ids.length > 0){
            for (Integer id : ids) {
                dao.updateFixedAreaIdByCustomerId(fixedAreaId,id);
            }
        }
    }

    @Override
    public void regist(Customer customer) {
          
        dao.save(customer);
        
    }

    @Override
    public Customer findByTelephone(String telephone) {
          
        return dao.findByTelephone(telephone);
    }

    @Override
    public void activedCustomer(String telephone) {
          
        dao.activedCustomer(telephone);
        
    }

    @Override
    public Customer login(String telephone, String password) {
          
        return dao.findByTelephoneAndPassword(telephone,password);
    }

    @Override
    public String findAddressByFixedAreaId(String address) {
          
        return dao.findAddressByFixedAreaId(address);
    }

}
  
