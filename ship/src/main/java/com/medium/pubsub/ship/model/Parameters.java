package com.medium.pubsub.ship.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This is a dummy class for randomly generating parameters
 *
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class Parameters {
    private float x;
    private float y;
    private float z;
    private float fuelPercentage;

    @Override
    public String toString() {
        return "Parameters{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", fuelPercentage=" + fuelPercentage +
                '}';
    }
}
