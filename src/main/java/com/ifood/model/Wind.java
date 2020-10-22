package com.ifood.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class Wind implements Serializable {

    private static final long serialVersionUID = 5733805357937068332L;

    private final Double speed;

    public Wind(Double speed) {
        this.speed = speed;
    }

    public Double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("speed", speed)
                .toString();
    }
}
