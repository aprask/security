package com.example.security.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public abstract class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_cost")
    private double itemCost;
    public Item() {}

    public Item(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }
}
