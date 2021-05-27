package com.google.custom_container_boot;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd; hh:mm:ss");
        try {
            Date date = formatter.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
