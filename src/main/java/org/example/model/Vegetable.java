package org.example.model;

import jakarta.persistence.*;

@Entity
public class Vegetable {
    @Id
    @SequenceGenerator(
            name = "vegetable_id_seq",
            sequenceName = "vegetable_id_seq",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vegetable_id_seq"
    )
    private int id;

    @Column(
            nullable = false
    )
    private String name;

    @Column(
            nullable = false
    )
    private double price;

    public Vegetable(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}