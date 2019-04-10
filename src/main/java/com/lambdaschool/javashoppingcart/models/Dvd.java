package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "dvd")
public class Dvd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dvdid;

    private String dvdtitle;

    private String description;

    private double price;

    @ManyToMany(mappedBy = "dvds")
    @JsonIgnoreProperties("dvds")
//    @JsonIgnore
    private Set<Store> stores = new HashSet<>();

    @OneToMany(mappedBy = "dvd")
//    @JsonIgnoreProperties("dvd")
    @JsonIgnore
    private Set<Requesteddvd> requesteddvds = new HashSet<>();

    @OneToMany(mappedBy = "dvd")
    @JsonIgnoreProperties("dvd")
    @JsonIgnore
    private Set<Dvdtopurchase> dvdtopurchases = new HashSet<>();

    public Dvd() {
    }

    public long getDvdid() {
        return dvdid;
    }

    public void setDvdid(long dvdid) {
        this.dvdid = dvdid;
    }

    public String getDvdtitle() {
        return dvdtitle;
    }

    public void setDvdtitle(String dvdtitle) {
        this.dvdtitle = dvdtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Requesteddvd> getRequesteddvds() {
        return requesteddvds;
    }

    public void setRequesteddvds(Set<Requesteddvd> requesteddvds) {
        this.requesteddvds = requesteddvds;
    }

    public Set<Dvdtopurchase> getDvdtopurchases() {
        return dvdtopurchases;
    }

    public void setDvdtopurchases(Set<Dvdtopurchase> dvdtopurchases) {
        this.dvdtopurchases = dvdtopurchases;
    }
}