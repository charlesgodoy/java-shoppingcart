package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartid;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private Set<Dvdtopurchase> items;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cartid")
    private Customer customer;

    public Cart() {
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }

    public Set<Dvdtopurchase> getItems() {
        return items;
    }

    public void setItems(Set<Dvdtopurchase> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonIgnore
    public Order getAsOrder() {

        Order order = new Order();

        Set<Requesteddvd> requesteddvds = new HashSet<>();

        for (Dvdtopurchase item : items) {

            requesteddvds.add(item.requestingDvds());
        }

        order.setItems(requesteddvds);

        order.setCustomer(customer);

        return order;
    }
}
