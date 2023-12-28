package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeUtils {

    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        //LocalDateTime.now().plusSeconds(24 * 3600 * 3);
        System.out.println(LocalDateTime.now().plusSeconds(24 * 3600 * 3));
    }
}
