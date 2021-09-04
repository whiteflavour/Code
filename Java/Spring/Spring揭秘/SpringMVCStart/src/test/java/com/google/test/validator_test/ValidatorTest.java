package com.google.test.validator_test;

import com.google.controller.LoginController;
import com.google.validator.LoginValidator;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void testValidator() {
        LoginValidator validator = new LoginValidator();
        LoginController controller = new LoginController();
        BindException errors = new BindException(controller, "loginController");
        ValidationUtils.invokeValidator(validator, controller, errors);
        assertTrue(errors.hasErrors());

        Map<String, Object> map = errors.getBindingResult().getModel();
        BindingResult result = (BindingResult) map.get("org.springframework.validation.BindingResult.loginController");
        System.out.println(result);
    }
}
