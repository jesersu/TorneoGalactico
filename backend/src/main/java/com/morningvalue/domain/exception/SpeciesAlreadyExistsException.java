package com.morningvalue.domain.exception;

public class SpeciesAlreadyExistsException extends RuntimeException {
    public SpeciesAlreadyExistsException(String name) {
        super("Species already exists with name: " + name);
    }
}
