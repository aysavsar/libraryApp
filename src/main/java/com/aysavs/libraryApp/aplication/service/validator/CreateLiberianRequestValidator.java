package com.aysavs.libraryApp.aplication.service.validator;

import com.aysavs.libraryApp.aplication.service.request.CreateLiberianRequest;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CreateLiberianRequestValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_SURNAME_LENGTH = 100;
    private static final int MAX_MAIL_LENGTH = 150;
    private static final int GSM_NUMBER_LENGTH = 10;

    public void validate(CreateLiberianRequest createLiberianRequest) {
        validateName(createLiberianRequest.getName());
        validateSurname(createLiberianRequest.getSurname());
        validateMailAddress(createLiberianRequest.getMailAddress());
        validateGsmNumber(createLiberianRequest.getGsmNumber());
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("Name cannot be blank");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Name is too long. Maximum length is "
                    + MAX_NAME_LENGTH + " characters");
        }
    }

    private void validateSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new ValidationException("Surname cannot be blank");
        }
        if (surname.length() > MAX_SURNAME_LENGTH) {
            throw new ValidationException("Surname is too long. Maximum length is "
                    + MAX_SURNAME_LENGTH + " characters");
        }
    }

    private void validateMailAddress(String mailAddress) {
        if (mailAddress == null || mailAddress.isBlank()) {
            throw new ValidationException("Mail address cannot be blank");
        }
        if (mailAddress.length() > MAX_MAIL_LENGTH) {
            throw new ValidationException("Mail address is too long. Maximum length is "
                    + MAX_MAIL_LENGTH + " characters");
        }
        if (!mailAddress.contains("@")) {
            throw new ValidationException("Invalid mail address format");
        }
    }

    private void validateGsmNumber(long gsmNumber) {
        String gsmString = String.valueOf(gsmNumber);
        if (gsmString.length() != GSM_NUMBER_LENGTH) {
            throw new ValidationException("GSM number must be exactly "
                    + GSM_NUMBER_LENGTH + " digits long");
        }
    }
}
