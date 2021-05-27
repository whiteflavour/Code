package com.google.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
    public static void main(String[] args) {
        Locale china = new Locale("zh", "CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages", china);
        System.out.println(resourceBundle.getString("menu.file"));
        System.out.println(resourceBundle.getString("menu.edit"));
    }
}
