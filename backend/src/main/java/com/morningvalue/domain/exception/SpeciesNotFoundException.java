package com.morningvalue.domain.exception;

public class SpeciesNotFoundException extends RuntimeException {
    public SpeciesNotFoundException(Long id) {
        super("Species not found with id: " + id);
    }
}
