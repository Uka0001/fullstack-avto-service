package com.example.autoservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum OrderStatus {
    ACCEPTED("accepted"),
    IN_PROGRESS("in progress"),
    COMPLETED("completed successfully"),
    NOT_COMPLETED("not completed successfully"),
    PAID("paid");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

}
