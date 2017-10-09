package com.itheima.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.itheima.crm.domain.Customer;

/**  
 * ClassName:CustomerDao <br/>  
 * Function:  <br/>  
 * Date:     2017年9月22日 下午3:36:25 <br/>       
 */
public interface CustomerDao extends JpaRepository<Customer, Integer>{

    List<Customer> findByFixedAreaIdIsNull();
    @Query("from Customer where fixedAreaId = ?")
    List<Customer> findCustomersAssociatedToFixedArea(String fixedAreaId);
    
    @Modifying
    @Query("update Customer set fixedAreaId = null where fixedAreaId = ?")
    void updateFixedAreanull(String fixedAreaId);
    @Modifying
    @Query("update Customer set fixedAreaId = ? where id = ?")
    void updateFixedAreaIdByCustomerId(String fixedAreaId, Integer id);
    //根据手机号查找用户
    Customer findByTelephone(String telephone);
    
    @Modifying
    @Query("update Customer set type = 1 where telephone = ?")
    void activedCustomer(String telephone);
    //登陆
    Customer findByTelephoneAndPassword(String telephone, String password);
    //查询定区id
    @Query("select fixedAreaId from Customer where address = ?")
    String findAddressByFixedAreaId(String address);     
}
  
