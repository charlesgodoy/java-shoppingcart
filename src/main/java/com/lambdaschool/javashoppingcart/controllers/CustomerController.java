package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.*;
import com.lambdaschool.javashoppingcart.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    DvdRepository dvdRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    DvdtopurchaseRepository dvdtopurchaseRepo;

    @Autowired
    OrderRepository orderRepo;

    @GetMapping(value = "/dvds")
    public List<Dvd> listAllDvds() {
        return dvdRepo.findAll();
    }

    @PostMapping(value = "/customer/{customerid}/dvd/{dvdid}")
    public Dvdtopurchase addDvdToCart(@PathVariable long customerid, @PathVariable long dvdid) {

        Optional<Customer> foundCustomer = customerRepo.findById(customerid);
        Optional<Dvd> foundDvd = dvdRepo.findById(dvdid);

        if (foundCustomer.isPresent() && foundDvd.isPresent()) {

            Cart cart = foundCustomer.get().getCart();

            if (cart != null) {

                Set<Dvdtopurchase> items = cart.getItems();

                for (Dvdtopurchase item : items) {

                    if (item.getDvd().getDvdid() == dvdid) {

                        item.setQuantity(item.getQuantity() + 1);
                        return dvdtopurchaseRepo.save(item);
                    }
                }
            } else {
                cart = new Cart();

                cart.setCustomer(foundCustomer.get());

                cart = cartRepo.save(cart);
            }

            Dvdtopurchase itemToAdd = new Dvdtopurchase();

            itemToAdd.setCart(cart);

            Dvd dvd = foundDvd.get();

            itemToAdd.setDvd(dvd);

            itemToAdd.setQuantity(1);

            return dvdtopurchaseRepo.save(itemToAdd);

        } else {
            return null;
        }
    }

    @PostMapping(value = "/customer/order/{customerid}")
    public Order orderItemsInCart(@PathVariable long customerid) {

        Optional<Customer> foundCustomer = customerRepo.findById(customerid);
        Order order = null;

        if (foundCustomer.isPresent()) {

            Customer customer = foundCustomer.get();

            Cart cart = customer.getCart();

            if (cart != null) {

                Set<Dvdtopurchase> items = cart.getItems();

                if (items != null) {

                    order = cart.getAsOrder();

                    order = orderRepo.save(order);

                    for (Dvdtopurchase item : items) {

                        item.setCart(null);

                        dvdtopurchaseRepo.save(item);

                        dvdtopurchaseRepo.delete(item);
                    }
                    cartRepo.save(cart);
                }
            }
        }
        return order;
    }
}
