package com.touristguide.backend.exception;

// This is a custom exception - basically our own "error type" that we invented,
// specifically for the situation of "someone asked for something that doesn't exist."
// It works exactly like Java's built-in RuntimeException, we're just giving it
// a more meaningful name so our code reads clearly.
public class ResourceNotFoundException extends RuntimeException {

    // "extends RuntimeException" means this class inherits everything a normal
    // exception can do, and we just add one thing: a constructor that takes
    // a message, e.g. "Destination not found"
    public ResourceNotFoundException(String message) {
        super(message); // hands the message up to the parent RuntimeException class
    }
}