package com.lambdaschool.javashoppingcart.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Requesteddvd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requesteddvdid;

    private int itemqty;

    @ManyToOne
    @JoinColumn(name = "dvdid")
    @JsonIgnoreProperties("requesteddvds")
    private Dvd dvd;


    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnoreProperties("orders")
    private Order order;

    public Requesteddvd() {
    }

    public long getRequesteddvdid() {
        return requesteddvdid;
    }

    public void setRequesteddvdid(long requesteddvdid) {
        this.requesteddvdid = requesteddvdid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public int getItemqty() {
        return itemqty;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }
}
