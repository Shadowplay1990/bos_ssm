package com.tang.bos.entity;

import com.tang.bos.entity.Staff;

/**
 * Created by tang on 17-5-19.
 */
public class Decidedzone {

    private int id;
    private Staff staff;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
