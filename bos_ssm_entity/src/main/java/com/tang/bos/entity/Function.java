package com.tang.bos.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tang on 17-6-13.
 */
@JsonSerialize
public class Function{

    private int id;
    private String name;
    private String code;
    private String description;
    private String page;
    private int generatemeun;
    private int zindex;
    @JsonBackReference//忽略该属性，防止递归
    private Function parent;
    @JsonManagedReference
    private List<Function> children;

    public Function getParent() {
        return parent;
    }

    public void setParent(Function parent) {
        this.parent = parent;
    }

    public List<Function> getChildren() {
        return children;
    }

    public void setChildren(List<Function> children) {
        this.children = children;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getGeneratemeun() {
        return generatemeun;
    }

    public void setGeneratemeun(int generatemeun) {
        this.generatemeun = generatemeun;
    }

    public int getZindex() {
        return zindex;
    }

    public void setZindex(int zindex) {
        this.zindex = zindex;
    }
}
