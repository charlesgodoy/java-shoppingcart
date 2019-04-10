package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Transactional //Need both of these annotations to modify data.
    @Modifying
    @Query(value = "insert into shopper (firstname, lastname, billingaddress, phonenumber, paymethod) VALUES(:firstname, :lastname, :billingaddress, :phonenumber, :paymethod)", nativeQuery = true)
    void addShopper(String firstname, String lastname, String billingaddress, String phonenumber, String paymethod);

    Customer findByFirstnameAndLastnameAndBillingaddress(String firstname, String lastname, String billingaddress);}
