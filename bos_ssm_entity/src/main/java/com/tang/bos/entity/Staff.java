package com.tang.bos.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tang on 17-5-18.
 */
public class Staff {

    private int id;
    private String name;
    private String telephone;
    private String haspda;
    private String deltag;
    private String station;
    private Set decidedzones=new HashSet();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHaspda() {
        return haspda;
    }

    public void setHaspda(String haspda) {
        this.haspda = haspda;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Set getDecidedzones() {
        return decidedzones;
    }

    public void setDecidedzones(Set decidedzones) {
        this.decidedzones = decidedzones;
    }
}
