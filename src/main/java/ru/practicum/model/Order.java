package ru.practicum.model;

import java.util.List;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private Integer rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, Integer rentTime, String deliveryDate, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    public Order() {
    }

    public List getColor() {
        return color;
    }

    public Order setColor(List color) {
        this.color = color;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public Order setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public Order setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Order setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public Order setMetroStation(String metroStation) {
        this.metroStation = metroStation;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Order setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Order setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
