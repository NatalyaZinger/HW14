package ru.netology.product;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }
}
