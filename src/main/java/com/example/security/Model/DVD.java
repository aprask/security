package com.example.security.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "dvds")
public class DVD extends Item {
    private String director;
    private Date year;
    private String genre;
    public DVD() {

    }
    public DVD(String itemName, double itemCost, String director, Date year, String genre) {
        super(itemName, itemCost);
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public int compareTo(@NotNull Item o) {
        return 0;
    }
}