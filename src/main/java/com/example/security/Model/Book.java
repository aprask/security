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
@Table(name = "books")
public class Book extends Item {
    private String author;
    private Date year;
    private String genre;
    public Book() {}
    public Book(String itemName, double itemCost, String author, Date year, String genre) {
        super(itemName, itemCost);
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Item o) {
        return 0;
    }
}