package com.quaint.sp.javabase.java8.helper;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author quaint
 */
@Data
@Accessors(chain = true)
public class Book{

    private String color;
    private Integer page;

    public Book() {
    }

    public Book(String color, Integer page) {
        this.color = color;
        this.page = page;
    }
}