package com.tang.bos.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tang on 17-5-18.
 */
@Component
public class Page<T> {

    private int currentPage;
    private int total;
    private int count;
    private List<T> rows;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
