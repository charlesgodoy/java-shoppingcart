package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeid;
    private String storename;

    @ManyToMany
    @JoinTable(name = "storedvds",
            joinColumns = {@JoinColumn(name = "storeid")},
            inverseJoinColumns = {@JoinColumn(name = "dvdid")})
    @JsonIgnoreProperties("stores")
    private Set<Dvd> dvds;

    public Store() {
    }

    public long getStoreid() {
        return storeid;
    }

    public void setStoreid(long storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public Set<Dvd> getDvds() {
        return dvds;
    }

    public void setDvds(Set<Dvd> dvds) {
        this.dvds = dvds;
    }
}
