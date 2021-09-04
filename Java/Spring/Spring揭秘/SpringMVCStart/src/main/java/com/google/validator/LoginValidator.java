package com.google.validator;

import com.google.controller.LoginController;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
    private static final int MIN_PASSWORD_LENGTH = 6;

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginController.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
        LoginController loginController = (LoginController) target;
        if (loginController.getPassword() != null
                && loginController.getPassword().trim().length() < MIN_PASSWORD_LENGTH) {
            errors.rejectValue("password", "field.min.length",
                    new Object[]{MIN_PASSWORD_LENGTH}, "password must be at least [" + MIN_PASSWORD_LENGTH + "] characters in length.");
        }
    }
}
