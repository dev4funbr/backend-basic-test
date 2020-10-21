package com.ifood.controllers;

public class AboutResponse {

    private final String status;

    public AboutResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}