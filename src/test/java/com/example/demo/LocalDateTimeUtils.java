package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeUtils {

    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(date);
    }
}
