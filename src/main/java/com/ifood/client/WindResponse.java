package com.ifood.client;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class WindResponse implements Serializable {

    private static final long serialVersionUID = 2940293465906047211L;

    private Double speed;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("speed", speed)
                .toString();
    }
}
