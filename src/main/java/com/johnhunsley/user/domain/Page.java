package com.johnhunsley.user.domain;

import java.util.List;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 15/12/2016
 *         Time : 14:06
 */
public class Page<T> {

    private List<T> pagedItems;

    private long totalItems;

    private int totalPages;

    public Page() {}

    public Page(List<T> pagedItems, long totalItems, int totalPages) {
        this.pagedItems = pagedItems;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    public List<T> getPagedItems() {
        return pagedItems;
    }

    public void setPagedItems(List<T> pagedItems) {
        this.pagedItems = pagedItems;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
