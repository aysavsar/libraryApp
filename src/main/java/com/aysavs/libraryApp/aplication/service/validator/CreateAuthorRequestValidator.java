package com.aysavs.libraryApp.aplication.service.validator;

import com.aysavs.libraryApp.aplication.service.request.CreateAuthorRequest;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorRequestValidator {

    private static final int MAX_CHARACTER_COUNT = 100;

    public void validate(CreateAuthorRequest createAuthorRequest) {
        int nameLength = createAuthorRequest.getName().length();
        int surnameLength = createAuthorRequest.getSurname().length();

        if (nameLength > MAX_CHARACTER_COUNT) {
            throw new ValidationException("Name is too long");
        }

        if (surnameLength > MAX_CHARACTER_COUNT) {
            throw new ValidationException("Surname is too long");
        }
    }
}
