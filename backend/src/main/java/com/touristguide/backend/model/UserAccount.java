package com.touristguide.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank means: this field can't be empty, and can't be just spaces.
    // The text inside quotes is the error message shown if someone breaks the rule.
    @NotBlank(message = "Name is required")
    private String name;

    // @Email checks the text actually looks like a real email address
    // (has an @ symbol, a domain, etc.) before it's accepted.
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    // @Size sets a minimum/maximum length - here we're requiring at least
    // 6 characters for a password, which is a very basic safety net.
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<TripCart> savedTrips = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // Getters and setters stay exactly the same as before - no changes needed there
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<TripCart> getSavedTrips() { return savedTrips; }
    public void setSavedTrips(List<TripCart> savedTrips) { this.savedTrips = savedTrips; }
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}