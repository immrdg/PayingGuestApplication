package org.example.payingguestapplication.models;

public enum Status {
    OCCUPIED("OCCUPIED"),AVAILABLE("AVAILABLE"),;
    private final String status;


    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
