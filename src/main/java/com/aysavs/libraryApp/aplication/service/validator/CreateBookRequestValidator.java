package com.aysavs.libraryApp.aplication.service.validator;

import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateBookRequestValidator {

    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MAX_TYPE_LENGTH = 100;
    private static final int MAX_LANGUAGE_LENGTH = 100;
    private static final int MAX_PUBLISHING_HOUSE_LENGTH = 100;

    public void validate(CreateBookRequest createBookRequest) {
        validateTitle(createBookRequest.getTitle());
        validateType(createBookRequest.getType());
        validateLanguage(createBookRequest.getLanguage());
        validatePublishingHouse(createBookRequest.getPublishingHouse());
        validateEditionNumber(createBookRequest.getEditionNumber());
        validatePublicationDate(createBookRequest.getPublicationDate());
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new ValidationException("Title cannot be blank");
        }
        if (title.length() > MAX_TITLE_LENGTH) {
            throw new ValidationException("Title is too long. Maximum length is "
                    + MAX_TITLE_LENGTH + " characters");
        }
    }

    private void validateType(String type) {
        if (type == null || type.isBlank()) {
            throw new ValidationException("Type cannot be blank");
        }
        if (type.length() > MAX_TYPE_LENGTH) {
            throw new ValidationException("Type is too long. Maximum length is "
                    + MAX_TYPE_LENGTH + " characters");
        }
    }

    private void validateLanguage(String language) {
        if (language == null || language.isBlank()) {
            throw new ValidationException("Language cannot be blank");
        }
        if (language.length() > MAX_LANGUAGE_LENGTH) {
            throw new ValidationException("Language is too long. Maximum length is "
                    + MAX_LANGUAGE_LENGTH + " characters");
        }
    }

    private void validatePublishingHouse(String publishingHouse) {
        if (publishingHouse == null || publishingHouse.isBlank()) {
            throw new ValidationException("Publishing house cannot be blank");
        }
        if (publishingHouse.length() > MAX_PUBLISHING_HOUSE_LENGTH) {
            throw new ValidationException("Publishing house is too long. Maximum length is "
                    + MAX_PUBLISHING_HOUSE_LENGTH + " characters");
        }
    }

    private void validateEditionNumber(int editionNumber) {
        if (editionNumber <= 0) {
            throw new ValidationException("Edition number must be positive");
        }
    }

    private void validatePublicationDate(Date publicationDate) {
        if (publicationDate == null) {
            throw new ValidationException("Publication date cannot be null");
        }
        if (publicationDate.after(new Date())) {
            throw new ValidationException("Publication date cannot be in the future");
        }
    }
}
