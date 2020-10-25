package com.example.demo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author cui
 */
public class MyPage<T> implements Serializable {

    private static final long serialVersionUID = 5925101851082556646L;

    private List<T> content;

    private long totalElements;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
