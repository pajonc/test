package com.gp.horserace.model;

import java.util.Objects;

/**
 * Created on 10/25/2017
 * lombok
 */
public class Horse {

    private String name;
    private int power;

    public Horse(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return power == horse.power &&
                Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
