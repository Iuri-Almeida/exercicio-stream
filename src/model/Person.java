package model;

import model.enums.Generation;
import sign.Sign;

import java.time.LocalDate;

public class Person {

    private String name;
    private String city;
    private LocalDate date;
    private Sign sign;
    private String risingSign;
    private Integer age;
    private Generation generation;

    public Person(String name, String city, LocalDate date, Sign sign, String risingSign, Integer age, Generation generation) {
        this.name = name;
        this.city = city;
        this.date = date;
        this.sign = sign;
        this.risingSign = risingSign;
        this.age = age;
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    public Sign getSign() {
        return sign;
    }

    public String getRisingSign() {
        return risingSign;
    }

    public Integer getAge() {
        return age;
    }

    public Generation getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return name;
    }

}
