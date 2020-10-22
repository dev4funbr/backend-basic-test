package com.ifood.client;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class CurrentWeatherResponse implements Serializable {

    private static final long serialVersionUID = 8525697565808228652L;

    private String main;

    private String description;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("main", main)
                .add("description", description)
                .toString();
    }
}