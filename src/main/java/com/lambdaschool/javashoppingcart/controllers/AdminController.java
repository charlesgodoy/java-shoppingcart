package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.*;
import com.lambdaschool.javashoppingcart.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    @Autowired
    DvdRepository dvdRepo;

    @Autowired
    StoreRepository storeRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/stores")
    public List<Store> listAllStores() {
        return storeRepo.findAll();
    }

    @GetMapping(value = "/orders")
    public List<Order> listAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping(value = "/customers")
    public List<Customer> listAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/dvd")
    public Dvd addNewdvd(@RequestBody Dvd dvd) throws URISyntaxException {
        return dvdRepo.save(dvd);
    }

    @PostMapping("/store")
    public Store addNewStore(@RequestBody Store store) throws URISyntaxException {
        return storeRepo.save(store);
    }

    @PostMapping("/shopper")
    public Customer addNewShopper(@RequestBody Customer customer) throws URISyntaxException {

        return customerRepo.save(customer);
    }
}
