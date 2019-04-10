package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dvdtopurchase")
public class Dvdtopurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dvdtopurchaseid;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "dvdid")
    @JsonIgnoreProperties("dvdtopurchases")
    private Dvd dvd;

    @ManyToOne
    @JoinColumn(name = "cartid")
    @JsonIgnoreProperties("items")
    private Cart cart;

    public Dvdtopurchase() {
    }

    public long getDvdtopurchaseid() {
        return dvdtopurchaseid;
    }

    public void setDvdtopurchaseid(long dvdtopurchaseid) {
        this.dvdtopurchaseid = dvdtopurchaseid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    @JsonIgnore
    public Requesteddvd requestingDvds() {

      Requesteddvd requesteddvd = new Requesteddvd();

      requesteddvd.setItemqty(quantity);

      requesteddvd.setDvd(dvd);

      return requesteddvd;
    }
}
