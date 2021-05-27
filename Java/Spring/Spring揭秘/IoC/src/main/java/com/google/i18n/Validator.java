package com.google.i18n;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class Validator {
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String validate(String msg) {
        if (msg.equals("fuck")) {
            return messageSource.getMessage("hello", null, Locale.CHINA);
        }
        return messageSource.getMessage("errors", null, Locale.CHINA);
    }
}
