package com.example.mvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 60)
    @Size(min = 3, max = 60)
    private String title;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull
    @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
    @DecimalMax(value = "100.00", message = "Price must not be greater than 100.00")
    @Digits(integer = 3, fraction = 2, message = "Invalid price format")
    private BigDecimal price;

    @NotNull
    @Column(length = 30)
    @Pattern(regexp = "^[A-Z]+[a-zA-Z\\s]*$", message = "Invalid genre format")
    private String genre;

    @NotNull
    @Column(length = 5)
    @Pattern(regexp = "^[A-Z]+[a-zA-Z0-9\"'\\s-]*$", message = "Invalid rating format")
    private String rating;

    public Movie() {
    }

    public Movie(String title, LocalDate releaseDate, String genre, String rating, BigDecimal price) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}
